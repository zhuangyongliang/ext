package com.ext.example.wizard.resource;

import wt.util.resource.RBEntry;
import wt.util.resource.RBUUID;
import wt.util.resource.WTListResourceBundle;

@RBUUID("com.ext.example.wizard.resource.WizardResource")
public class WizardResource extends WTListResourceBundle {

	    @RBEntry("Wizard Example")
	    public static final String WIZARD_DESCRIPTION = "object.MR_CREATION_WIZARD.description";    
	    @RBEntry("../../com/ext/images/exampleWizard.gif")	    
	    public static final String WIZARD_ICON = "object.MR_CREATION_WIZARD.icon";
	    @RBEntry("Wizard Example")
	    public static final String WIZARD_TOOLTIP = "object.MR_CREATION_WIZARD.tooltip";
	    @RBEntry("MR Creation Wizard")
	    public static final String WIZARD_TITLE = "object.MR_CREATION_WIZARD.title";
		
		@RBEntry("Select Template")
	    public static final String SELECT_TEMPLATE = "SELECT_TEMPLATE";
	   
	    
	    
}
