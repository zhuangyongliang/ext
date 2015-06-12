package com.ext.example.wizard.builder;

import wt.util.WTException;

import com.ptc.mvc.components.AbstractComponentBuilder;
import com.ptc.mvc.components.ColumnConfig;
import com.ptc.mvc.components.ComponentBuilder;
import com.ptc.mvc.components.ComponentConfig;
import com.ptc.mvc.components.ComponentConfigFactory;
import com.ptc.mvc.components.ComponentParams;
import com.ptc.mvc.components.TableConfig;
import com.ptc.mvc.util.ClientMessageSource;
import com.ext.example.wizard.util.MRCreationWizardUtils;

@ComponentBuilder(value="example.selectTemplateBuilder")

public class SelectTemplateBuilder extends AbstractComponentBuilder
{
	private static final String RESOURCE = "com.ext.example.wizard.resource.WizardResource";

	/* (non-Javadoc)
	 * @see com.ptc.mvc.components.ComponentConfigBuilder#buildComponentConfig(com.ptc.mvc.components.ComponentParams)
	 */
	public ComponentConfig buildComponentConfig(ComponentParams params) throws WTException {

        ComponentConfigFactory factory = getComponentConfigFactory();
        ClientMessageSource messageSource = getMessageSource(RESOURCE);

        TableConfig table = factory.newTableConfig();
        table.setLabel(messageSource.getMessage("SELECT_TEMPLATE"));
        
        table.setSelectable(true);
        table.setSingleSelect(true); // adds radio buttons instead of checkbox

         // add columns for the template attributes listed in the xconf
        String[] attributesList = MRCreationWizardUtils.getTemplateAttributes();
        for (int i = 0; i < attributesList.length; i++){
        	ColumnConfig column = factory.newColumnConfig(attributesList[i], false);
        	column.setSortable(true);
        	table.addComponent(column);
        }

        return table;
    }

	/* (non-Javadoc)
	 * @see com.ptc.mvc.components.ComponentDataBuilder#buildComponentData(com.ptc.mvc.components.ComponentConfig, com.ptc.mvc.components.ComponentParams)
	 */
	public Object buildComponentData(ComponentConfig config, ComponentParams params) throws Exception {
		return MRCreationWizardUtils.getTemplateDocuments();
	}

}
