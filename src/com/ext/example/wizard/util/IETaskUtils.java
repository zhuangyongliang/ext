package com.ext.example.wizard.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import wt.org.WTUser;
import wt.session.SessionHelper;
import wt.util.WTException;
import wt.util.WTProperties;

import com.infoengine.SAK.Task;
import com.infoengine.object.factory.Group;
import com.infoengine.util.IEException;

/**
 * Utils class that contains java code able to call an InfoEngine task
 * 
 * @author dcernat
 *
 */
public class IETaskUtils {

	/**
	 * Sets the parameters for an instance of a class representing an InfoEngine task
	 * 
	 * @param task - InfoEngine task for whcih to set the parameters
	 * @param params - map with parameters to set
	 * @param groupOutName - name of the output group of the InfoEngine task
	 * @return the InfoEngine task will all parameters set
	 * @throws WTException 
	 * @throws IOException
	 */
	private static Task setTaskParams(Task task, HashMap<String, Object>  params, String groupOutName) throws WTException, IOException 
	{
    	WTUser user = (WTUser) SessionHelper.getPrincipal();        
    	// Get the Windchill Adapter VMName
    	WTProperties properties = WTProperties.getLocalProperties();
    	String WTADAPTER_VMNAME = properties.getProperty("wt.federation.ie.VMName");
    	
    	if (params != null)
    	{
    		Iterator<String> it = params.keySet().iterator();
        	while (it.hasNext()){
             	String key = it.next();
             	task.addParam(key, params.get(key));
       		}
    	}
    	
    	task.setUsername(user.getAuthenticationName());
    	task.addParam("group_out", groupOutName);
    	task.addProcessor(WTADAPTER_VMNAME);
    	task.addParam("supporting-adapter", WTADAPTER_VMNAME);
		
    	return task;
	}
	
	/**
	 * Executes an InfoEngine task
	 * 
	 * @param taskPath - path of the xml file for the InfoEngine task
	 * @param params - map containing the parameters used by the InfoEngine task
	 * @param returnGroupName - name of the output group of the task
	 * @return output group of the InfoEngine task 
	 */
	public static Group executeIETask(String taskPath, HashMap<String,Object> params, String returnGroupName)
	{
		Task task = new Task(taskPath);
		
		Group outputGroup = null;
		 try{
			 task = setTaskParams(task, params, returnGroupName);				  
			 task.invoke();	
			 outputGroup = task.getGroup(returnGroupName);

		 }
		 catch (IOException io){
			  io.printStackTrace();
		  }catch (IEException iee){
			  iee.printStackTrace();
		  }
		  catch (WTException wt){
			  wt.printStackTrace();
		  }
		  
		  return outputGroup;
	}
	
}
