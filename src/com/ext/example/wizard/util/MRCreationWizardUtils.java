package com.ext.example.wizard.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import wt.doc.WTDocument;
import wt.epm.EPMDocument;
import wt.fc.Persistable;
import wt.fc.ReferenceFactory;
import wt.fc.WTReference;
import wt.services.applicationcontext.implementation.ServiceProperties;
import wt.util.WTException;
import wt.util.WTProperties;

import com.infoengine.object.factory.Att;
import com.infoengine.object.factory.Element;
import com.infoengine.object.factory.Group;

public class MRCreationWizardUtils {
	
	static ReferenceFactory rf = new ReferenceFactory();

    public static String getElementSubtype(){
    	
    	String propertyName = MRCreationWizardConstants.ELEMENT_SUBTYPE;
    	return getProperty(propertyName);
    }
    
    public static String getOperationSubtype(){
    	
    	String propertyName = MRCreationWizardConstants.OPERATION_SUBTYPE;
    	return getProperty(propertyName);
    }
    
    public static String getTemplateSubtype(){
    	
    	String propertyName = MRCreationWizardConstants.TEMPLATE_SUBTYPE;
    	return getProperty(propertyName);
    }
    
    private static String getProperty(String propertyName) {

    	String value = "";
    	try {
            Properties wcProp = ServiceProperties.getServiceProperties("WTServiceProviderFromProperties");
                             //WTProperties.getLocalProperties();            
            value = wcProp.getProperty(propertyName);
            System.out.println("value = " + value);
         }
         catch (  WTException ioe ) {
            System.err.println("Failed to obtain property " + propertyName);
            ioe.printStackTrace();
         }
    	
    	return value;
    }
    
    public static String[] getTemplateAttributes(){
    	
    	String propertyName = MRCreationWizardConstants.TEMPLATE_ATTRIBUTES;
    	String propertyValue = getProperty(propertyName);

    	return propertyValue.split(",");
    }
	
	/**
	 * Gets the obid value for a Persistable object
	 * 
	 * @param persistable - Persistable object for which to get the obid
	 * @return String value of the obid for the specified Persistable
	 */
	public static String getObid(Persistable persistable){
		String obid = null;
		
		if (persistable == null){
			return obid;
		}
		
		try {
			obid = rf.getReferenceString(persistable);
		} catch (WTException e) {
			e.printStackTrace();
		}
		return obid;
	}
	
	public static Persistable getPersistableObject(String obid){		
		Persistable persistable = null;
		try {
			WTReference reference = rf.getReference(obid);
			persistable = reference.getObject();
		} catch (WTException e) {
			e.printStackTrace();
		}
		return persistable;
	}
	

	public static List<WTDocument> getTemplateDocuments() 
	{
		// task params
		String taskPath = "com/ext/example/wizard/GetTemplateDocuments.xml";
		String returnGroupName = "allTemplates";
		Group templatesGroup = IETaskUtils.executeIETask(taskPath, null, returnGroupName);
		System.out.println("Document count = " + templatesGroup.getElementCount());
		List<WTDocument> docsList = new ArrayList<WTDocument>();
		
		if (templatesGroup != null && templatesGroup.getElementCount() > 0){
			 for (int i = 0; i < templatesGroup.getElementCount(); i++){
				 Element currentElement = templatesGroup.getElementAt(i);
				 
				 Att obidAtt = currentElement.getAtt("obid");
				 String obidValue = (obidAtt != null)? obidAtt.getValue().toString():"";
				 System.out.println("obidValue =  " + obidValue);
				 WTDocument wtdoc = getWTDocument(UfidHelper.getShortOid(obidValue));
				 
				 docsList.add(wtdoc);
			 }
		}
		
		return docsList;
	}
	
	public static WTDocument getWTDocument(String obid){
	    WTDocument doc = null;
		Persistable persistable = getPersistableObject(obid);
		if (persistable instanceof WTDocument){
			doc = (WTDocument)persistable;
		}
		return doc;
	}

}
