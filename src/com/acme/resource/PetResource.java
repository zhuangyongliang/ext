package com.acme.resource;

import wt.util.resource.RBEntry;
import wt.util.resource.RBUUID;
import wt.util.resource.WTListResourceBundle;


@RBUUID("com.acme.resource.PetResource")
public class PetResource extends WTListResourceBundle {
  
    @RBEntry("Pets")
    public static final String PET_TABLE_LABEL="pet_table_label";
    

}
