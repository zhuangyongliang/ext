package com.acme;

import java.sql.Timestamp;
import java.util.Date;

import wt.content.ContentHolder;
import wt.fc.WTObject;
import wt.ownership.Ownable;
import wt.util.WTException;

import com.ptc.windchill.annotations.metadata.ColumnProperties;
import com.ptc.windchill.annotations.metadata.GenAsPersistable;
import com.ptc.windchill.annotations.metadata.GeneratedProperty;
import com.ptc.windchill.annotations.metadata.PropertyConstraints;




@GenAsPersistable(superClass=WTObject.class,interfaces={ContentHolder.class, Ownable.class},
properties={@GeneratedProperty(name="name", type = String.class,columnProperties=@ColumnProperties(index=true),constraints=@PropertyConstraints(required=true,upperLimit=60)),
            @GeneratedProperty(name="kind", type=PetKind.class,constraints=@PropertyConstraints(upperLimit=40)),
            @GeneratedProperty(name="dateOfBirth",type=Timestamp.class),
            @GeneratedProperty(name="fixed",type=boolean.class)
})
public class Pet extends _Pet{
    static final long serialVersionUID = 1;
    
    public static Pet newPet() throws WTException{
        final Pet aPet = new Pet();
        aPet.initialize();
        return aPet;
    }
    

}
