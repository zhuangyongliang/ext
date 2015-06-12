package com.ext.resource;

import wt.util.resource.RBComment;
import wt.util.resource.RBEntry;
import wt.util.resource.RBPseudo;
import wt.util.resource.RBUUID;
import wt.util.resource.WTListResourceBundle;

@RBUUID("com.ext.resource.NavResource_zh_CN")
public class NavResource_zh_CN extends WTListResourceBundle {
    
    @RBEntry("定制(<u class='mnemonic'>C</u>)")
    @RBComment("Title for Extension tab on Navigator.")
    public static final String EXTENSION_DESCRIPTION = "object.extension navigation.description";

    @RBEntry("C")
    @RBPseudo(false)
    @RBComment("Hotkey for Extension tab on Navigator.")
    public static final String EXTENSION_HOTKEY = "object.extension navigation.hotkey";

    @RBEntry("定制")
    @RBComment("Tooltip for Extension tab on Navigator.")
    public static final String EXTENSION_TOOLTIP = "object.extension navigation.tooltip";
    
    @RBEntry("示例")
    public static final String NAVIGATION_EXAMPLE_DESCRIPTION = "navigation.example.description";
    
    @RBEntry("示例")
    public static final String NAVIGATION_EXAMPLE_TITLE = "navigation.example.title";
    
    @RBEntry("示例")
    public static final String NAVIGATION_EXAMPLE_TOOLTIP = "navigation.example.tooltip";
    
    @RBEntry("../../com/ext/images/example.gif")
    public static final String NAVIGATION_EXAMPLE_ICON = "navigation.example.icon";
    
    @RBEntry("Suggestion示例")
    public static final String OBJECT_SUGGESTION_DESCRIPTION = "object.suggestionExample.description";
    
    @RBEntry("Customization One")
    public static final String EXT_ACTION1_DESCRIPTION = "extNavigator.extAction1.description";
    
    @RBEntry("Customization Two")
    public static final String EXT_ACTION2_DESCRIPTION = "extNavigator.extAction2.description";
}

