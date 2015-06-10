package com.acme.mvc;

import wt.fc.PersistenceHelper;
import wt.query.QuerySpec;
import wt.templateutil.table.ColumnIdentifier;
import wt.util.WTException;
import wt.util.WTMessage;

import com.acme.Pet;
import com.acme.resource.PetResource;
import com.ptc.core.components.descriptor.DescriptorConstants.ColumnIdentifiers;
import com.ptc.mvc.components.AbstractComponentBuilder;
import com.ptc.mvc.components.ColumnConfig;
import com.ptc.mvc.components.ComponentBuilder;
import com.ptc.mvc.components.ComponentConfig;
import com.ptc.mvc.components.ComponentConfigFactory;
import com.ptc.mvc.components.ComponentParams;
import com.ptc.mvc.components.TableConfig;

@ComponentBuilder("com.acme.pet.PetTable")
public class PetTable extends AbstractComponentBuilder {
    private static final String RESOURCE= com.acme.resource.PetResource.class.getName();

    @Override
    public Object buildComponentData(ComponentConfig arg0, ComponentParams arg1) throws Exception {
        // TODO Auto-generated method stub
        return PersistenceHelper.manager.find(new QuerySpec(com.acme._Pet.class));
        
    }

    @Override
    public ComponentConfig buildComponentConfig(ComponentParams arg0) throws WTException {
        // TODO Auto-generated method stub
        final ComponentConfigFactory factory = getComponentConfigFactory();
        final TableConfig table = factory.newTableConfig();
        table.setType(Pet.class.getName());
        table.setShowCount(true);
        table.setLabel(WTMessage.getLocalizedMessage(RESOURCE, PetResource.PET_TABLE_LABEL, null));
        table.setSelectable(true);
        table.setShowCustomViewLink(false);
        final ColumnConfig name = factory.newColumnConfig("name", true);
        name.setInfoPageLink(true);
        name.setSortable(true);
        table.addComponent(name);
        table.addComponent(getColumnConfig(ColumnIdentifiers.INFO_ACTION,factory));
        table.addComponent(getColumnConfig(ColumnIdentifiers.NM_ACTIONS,factory));
        table.addComponent(getColumnConfig(ColumnIdentifiers.LAST_MODIFIED,factory));
        table.addComponent(getColumnConfig(Pet.KIND,factory));
        table.addComponent(getColumnConfig(Pet.DATE_OF_BIRTH,factory));
        table.addComponent(getColumnConfig(Pet.FIXED,factory));
        return table;
    }
    
    ColumnConfig getColumnConfig(final String id, final ComponentConfigFactory factory ){
        final ColumnConfig column = factory.newColumnConfig(id,true);
        column.setSortable(false);
        return column;
        
    }

}
