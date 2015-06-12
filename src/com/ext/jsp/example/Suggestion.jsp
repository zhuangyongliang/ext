<%@ taglib prefix="jca" uri="http://www.ptc.com/windchill/taglib/components"%> 
<%@ include file="/netmarkets/jsp/util/begin.jspf"%> 
<%@ taglib prefix="wrap" uri="http://www.ptc.com/windchill/taglib/wrappers"%> 

<style type="text/css"> 
tabledatafont { 
	padding: 0px 10px 0px 10px; 
} 
select.ppdata{ 
	width: 98%; 
	width: 150px; 
	align: left; 
} 
input.ppdata { 
	width: 150px; 
	align: left; 
} 
input { 
	width: 120px; 
	align: left; 
} 
.hlpTxt { 
    display:none; 
} 
</style> 

<b>Suggestion Sample</b> 
<fieldset class="x-fieldset x-form-label-left“ id="Visualization_and_Attributes" style="width: 1024px;"> 
	<legend>SUGGESTION SAMPLE</legend> 
	<table> 
	<tr> 
		<td scope="row" width="50" class="tableColumnHeaderfont" align="left">*Number:</td> 
		<td class="tabledatafont" align="left">&nbsp; 
			<wrap:suggestTextBox 
				name="number" 
				id="number" 
				serviceKey="NumberSuggest" 
				maxlength="30" 			
				size="10" 
				onblur="this.value=this.value.toUpperCase()"
			 /> 
		</td> 
		<td scope="row" width="50" class="tableColumnHeaderfont" align="left">Name:</td> 
		<td class="tabledatafont" align="left">&nbsp; 
			<wrap:textBox name="name" id="name" maxlength="100" size="20"/> 
		</td> 
	</tr> 
	</table> 
</fieldset> 
<%@ include file="/netmarkets/jsp/util/end.jspf"%> 
