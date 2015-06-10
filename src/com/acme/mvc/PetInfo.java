package com.acme.mvc;

import com.ptc.jca.mvc.builders.DefaultInfoComponentBuilder;
import com.ptc.mvc.components.ComponentBuilder;
import com.ptc.mvc.components.ComponentId;
import com.ptc.mvc.components.ComponentParams;
import com.ptc.mvc.components.InfoConfig;
import com.ptc.mvc.components.TypeBased;

@ComponentBuilder(ComponentId.INFOPAGE_ID)
@TypeBased("com.acme.Pet")
public class PetInfo extends DefaultInfoComponentBuilder {
    @Override
    protected InfoConfig buildInfoConfig(final ComponentParams params){
        final InfoConfig info = getComponentConfigFactory().newInfoConfig();
        info.setTabSet("petDetails");
        return info;
    }

}