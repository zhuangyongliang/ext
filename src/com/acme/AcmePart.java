package com.acme;



import wt.part.WTPart;
import wt.util.WTException;

import com.ptc.windchill.annotations.metadata.GenAsPersistable;
import com.ptc.windchill.annotations.metadata.GeneratedProperty;
import com.ptc.windchill.annotations.metadata.IconProperties;

@GenAsPersistable(
        superClass=WTPart.class,
        properties={
            @GeneratedProperty(name="sizeC", type=Integer.class, initialValue="3",
                               javaDoc="Integer value to represent the size of C.")
        },
        iconProperties=@IconProperties(standardIcon="netmarkets/images/stop.gif",openIcon="netmarkets/images/stop.gif")
    )
    public class AcmePart extends _AcmePart {
        static final long serialVersionUID = 1;
        public static AcmePart newAcmePart() throws WTException {
            AcmePart instance = new AcmePart();
            
            instance.initialize(); 
            
            return instance;
        }
    }
