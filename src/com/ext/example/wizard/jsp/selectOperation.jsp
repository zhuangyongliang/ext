<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.ptc.com/windchill/taglib/components" prefix="jca"%>
<%@ taglib uri="http://www.ptc.com/windchill/taglib/core" prefix="wc"%>
<%@ taglib uri="http://www.ptc.com/windchill/taglib/fmt" prefix="fmt"%>
<%@ taglib prefix="wctags" tagdir="/WEB-INF/tags" %>

<%@page import="com.ext.example.wizard.util.MRCreationWizardUtils"%>
<%@page import="com.ext.example.wizard.util.MRCreationWizardConstants"%>

<%@ include file="/netmarkets/jsp/components/beginWizard.jspf"%>
<%@ include file="/netmarkets/jsp/components/includeWizBean.jspf" %>

<%
	String operationSubtype = MRCreationWizardUtils.getOperationSubtype();
	String operationParameter = MRCreationWizardConstants.WIZARD_OPERATION_PARAM;
%>

<wctags:genericPicker 
   id="<%=operationParameter %>"
   objectType="<%=operationSubtype %>"
   label="Operation     :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"/>

<%@ include file="/netmarkets/jsp/util/end.jspf"%>