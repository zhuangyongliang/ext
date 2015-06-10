package com.acme.mvc;

import wt.util.WTException;

import com.acme.Pet;
import com.ptc.core.ui.resources.ComponentType;
import com.ptc.jca.mvc.components.AbstractAttributesComponentBuilder;
import com.ptc.jca.mvc.components.JcaAttributeConfig;
import com.ptc.jca.mvc.components.JcaGroupConfig;
import com.ptc.mvc.components.AttributePanelConfig;
import com.ptc.mvc.components.ComponentBuilder;
import com.ptc.mvc.components.ComponentConfigFactory;
import com.ptc.mvc.components.ComponentId;
import com.ptc.mvc.components.ComponentParams;
import com.ptc.mvc.components.CustomizableViewConfig;
import com.ptc.mvc.components.TypeBased;

@ComponentBuilder("primaryAttributes")
@TypeBased("com.acme.Pet")
public class PetInfoAttributesBuilder extends AbstractAttributesComponentBuilder {

    @Override
    protected AttributePanelConfig buildAttributesComponentConfig(final ComponentParams params) throws WTException {
        final ComponentConfigFactory factory = getComponentConfigFactory();
        final AttributePanelConfig panel;
        {
            panel = factory.newAttributePanelConfig(ComponentId.ATTRIBUTE_PANEL_ID);
            panel.setComponentType(ComponentType.WIZARD_ATTRIBUTES_TABLE);
            final JcaGroupConfig group;
            {
                group = (JcaGroupConfig) factory.newGroupConfig();
                group.setId("attributes");
                group.setLabel("Attributes");
                group.setIsGridLayout(true);
                group.addComponent(getAttribute(Pet.NAME, factory));
                group.addComponent(getAttribute(Pet.KIND, factory));
                group.addComponent(getAttribute(Pet.DATE_OF_BIRTH, factory));
                group.addComponent(getAttribute(Pet.FIXED, factory));
            }
            panel.addComponent(group);
        }
        return panel;
    }

    JcaAttributeConfig getAttribute(final String id, final ComponentConfigFactory factory) {
        final JcaAttributeConfig attribute = (JcaAttributeConfig)
                factory.newAttributeConfig();
        attribute.setId(id);
        return attribute;
    }
   

}
