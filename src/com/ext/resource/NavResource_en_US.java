package com.ext.resource;

import wt.util.resource.RBComment;
import wt.util.resource.RBEntry;
import wt.util.resource.RBPseudo;
import wt.util.resource.RBUUID;
import wt.util.resource.WTListResourceBundle;

@RBUUID("com.ext.resource.NavResource_en_US")
public class NavResource_en_US extends WTListResourceBundle {
    
    @RBEntry("Extesion(<u class='mnemonic'>C</u>)")
    @RBComment("Title for Extension tab on Navigator.")
    public static final String EXTENSION_DESCRIPTION = "object.extension navigation.description";

    @RBEntry("C")
    @RBPseudo(false)
    @RBComment("Hotkey for Extension tab on Navigator.")
    public static final String EXTENSION_HOTKEY = "object.extension navigation.hotkey";

    @RBEntry("Extension")
    @RBComment("Tooltip for Extension tab on Navigator.")
    public static final String EXTENSION_TOOLTIP = "object.extension navigation.tooltip";
    
    @RBEntry("Example")
    public static final String NAVIGATION_EXAMPLE_DESCRIPTION = "navigation.example.description";
    
    @RBEntry("Example")
    public static final String NAVIGATION_EXAMPLE_TITLE = "navigation.example.title";
    
    @RBEntry("Example")
    public static final String NAVIGATION_EXAMPLE_TOOLTIP = "navigation.example.tooltip";
    
    @RBEntry("../../com/ext/images/example.gif")
    public static final String NAVIGATION_EXAMPLE_ICON = "navigation.example.icon";
	
	@RBEntry("Suggestion Example")
	public static final String OBJECT_SUGGESTION_DESCRIPTION = "object.suggestionExample.description";
	
	@RBEntry("Customization One")
    public static final String EXT_ACTION1_DESCRIPTION = "extNavigator.extAction1.description";
    
    @RBEntry("Customization Two")
    public static final String EXT_ACTION2_DESCRIPTION = "extNavigator.extAction2.description";
}
