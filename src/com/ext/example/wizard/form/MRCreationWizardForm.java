package com.ext.example.wizard.form;

import wt.method.RemoteAccess;
import wt.util.WTException;

import com.ptc.core.components.forms.DynamicRefreshInfo;
import com.ptc.core.components.forms.FormProcessingStatus;
import com.ptc.core.components.forms.FormResult;
import com.ptc.core.components.forms.FormResultAction;
import com.ptc.core.components.util.FeedbackMessage;
import com.ptc.core.ui.resources.FeedbackType;
import com.ptc.netmarkets.util.beans.NmCommandBean;
import com.ext.example.wizard.util.MRCreationWizardConstants;

public class MRCreationWizardForm implements RemoteAccess {

	// Constants
	private static final String EMPTY_STRING = "";
	
	// Parameters
	private static final String ELEMENT_PARAM = MRCreationWizardConstants.WIZARD_ELEMENT_PARAM;
	private static final String OPERATION_PARAM = MRCreationWizardConstants.WIZARD_OPERATION_PARAM;
	private static final String TEMPLATE_PARAM = MRCreationWizardConstants.WIZARD_TEMPLATE_PARAM;
	
	/**
	 * Checks the validity of the parameters received from the wizard
	 * 
	 * @param commandBean
	 * @return
	 * @throws WTException
	 */
	public static FormResult validateProcess(NmCommandBean commandBean) throws WTException {
		System.out.println("Enter validateProcess()");
	    
	    FormResult result = new FormResult();
		
		// validate Element parameter
		String element = commandBean.getTextParameter(ELEMENT_PARAM);
		if (element == null || element.equals(EMPTY_STRING)){
			result.setStatus(FormProcessingStatus.FAILURE);
		    FeedbackMessage msg = new FeedbackMessage(FeedbackType.FAILURE, commandBean.getLocale(), "No Element selected", null);
			result.addFeedbackMessage(msg);
			result.setNextAction(FormResultAction.NONE);
		} 
		
		// validate Operation parameter
		String operation = commandBean.getTextParameter(OPERATION_PARAM);
		if (operation == null || operation.equals(EMPTY_STRING)){
			result.setStatus(FormProcessingStatus.FAILURE);
		    FeedbackMessage msg = new FeedbackMessage(FeedbackType.FAILURE, commandBean.getLocale(), "No Operation selected", null);
			result.addFeedbackMessage(msg);
			result.setNextAction(FormResultAction.NONE);
		} 
		
		// validate Template parameter
		String template = commandBean.getTextParameter(TEMPLATE_PARAM);
		if (template == null || template.equals(EMPTY_STRING)){
			result.setStatus(FormProcessingStatus.FAILURE);
		    FeedbackMessage msg = new FeedbackMessage(FeedbackType.FAILURE, commandBean.getLocale(), "No Template selected", null);
			result.addFeedbackMessage(msg);
			result.setNextAction(FormResultAction.NONE);
		} 
		
	 return result;
	}
	
	/**
	 * MR Creation Wizard action at Finish
	 * 
	 * @param commandBean
	 * @return
	 * @throws Exception 
	 */
	public static FormResult create(NmCommandBean commandBean) throws Exception
	{
		//validate process
	    System.out.println("Enter Create()");
		FormResult result = validateProcess(commandBean);
		 System.out.println("after Validate ");
		//if failure return the message
		if (result.getStatus() != null && result.getStatus().equals(FormProcessingStatus.FAILURE)){
			return result;
		}
		else {
				// getting the parameters received from the wizard
				String element   = commandBean.getTextParameter(ELEMENT_PARAM);
				String operation = commandBean.getTextParameter(OPERATION_PARAM);
				String template  = commandBean.getTextParameter(TEMPLATE_PARAM);
				
				System.out.println(element);
				System.out.println(operation);
				System.out.println(template);

				//set next results and refresh opener
				result.setStatus(FormProcessingStatus.SUCCESS);			
				//result.setNextAction(FormResultAction.REFRESH_OPENER);
				result.addDynamicRefreshInfo(new
				        DynamicRefreshInfo(commandBean.getActionOid(), commandBean.getElementOid(),NmCommandBean.DYNAMIC_UPD));
				
				return result;
		}
	}
}
