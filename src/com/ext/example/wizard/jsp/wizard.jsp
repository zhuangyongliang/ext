<%@ page errorPage="/netmarkets/jsp/util/error.jsp"%>
<%@ taglib prefix="jca" uri="http://www.ptc.com/windchill/taglib/components" %>

<%@ include file="/netmarkets/jsp/components/beginWizard.jspf"%>
<%@ include file="/netmarkets/jsp/components/includeWizBean.jspf" %>

<%@page import="com.ext.example.wizard.util.MRCreationWizardConstants"%>

<%
	String templateParamater = MRCreationWizardConstants.WIZARD_TEMPLATE_PARAM;
	String tableId = MRCreationWizardConstants.TEMPLATE_BUILDER_MVC_ID;
	System.out.println("tableId="+tableId);
%>

<script language="javascript">

 function onSubmit(skipValidation)
 {   
  	
	var selectedTemplate    =  getJCASelectedTableItems('<%=tableId%>', false);
    var selectedTemplateOid = oidUtils.normalize(selectedTemplate[0].value);
   
    var hiddenTemplateParam = document.getElementById('<%=templateParamater%>');
   
	hiddenTemplateParam.value = selectedTemplateOid;
   
	
	isApply = false;
    if (isIE && event) {
    	Event.stop(event);
    }
          
    formSubmitted = onSubmitMain(skipValidation);
   
    return formSubmitted;

 }
</script>

 <input type="hidden" name="<%=templateParamater %>" id="<%=templateParamater %>" value=""/>
	
 <jca:wizard buttonList="DefaultWizardButtonsNoApply" title="MR Creation Wizard">
 	<jca:wizardStep action="select_element_step" type="object" />
	<jca:wizardStep action="select_operation_step" type="object" />
 	<jca:wizardStep action="select_template_step" type="object" /> 	
 </jca:wizard>

 

 

<%@ include file="/netmarkets/jsp/util/end.jspf"%>