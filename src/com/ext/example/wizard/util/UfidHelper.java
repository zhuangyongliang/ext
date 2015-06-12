package com.ext.example.wizard.util;

import wt.fc.ObjectIdentifier;
import wt.util.WTException;

/**
 */
public class UfidHelper
{
    /**
     * Method getShortOid.
     * @param ufid String
     * @return String
     */
    public static String getShortOid( String ufid){
        if( ufid.indexOf("@") ==-1){
            //throw new Exception ("toUfid not complete: missing ':'"+ufid);
            //System.out.println("toUfid not complete: missing '@'"+ufid);
            return ufid;
        }
        if(  ufid.indexOf(":") ==-1){
            //throw new Exception ("toUfid not complete: missing ':'"+ufid);
            //System.out.println("toUfid not complete: missing ':'"+ufid);
            return ufid;
        }
        String obid = ufid.substring( 0, ufid.lastIndexOf(":"));
        return obid;
    }
     
    /**
     * Method getOidKey.
     * @param ufid String
     * @return String
     */
    public static String getOidKey( String ufid){
        ufid = getShortOid( ufid);
        if( ufid.indexOf(":") ==-1){
            //throw new Exception ("toUfid not complete: missing ':'"+ufid);
            //System.out.println("toUfid not complete: missing '@'"+ufid);
            return null;
        }
        String obid = ufid.substring( (ufid.lastIndexOf(":")+1) );
            //System.out.println("obidobidobidobidobid: "+obid);
        return obid;
    }
    
    /**
     * Method getRepository.
     * @param ufid String
     * @return String
     */
    public static String getRepository( String ufid){
        if( ufid.indexOf("@") ==-1){
            //throw new Exception ("toUfid not complete: missing ':'"+ufid);
            //System.out.println("toUfid not complete: missing '@'"+ufid);
            return null;
        }
        String repos = ufid.substring( ufid.lastIndexOf("@")+1);
        return repos;
    }
    /**
     * Method getGuid.
     * @param ufid String
     * @return String
     */
    public static String getGuid( String ufid){
        if( ufid.indexOf("@") ==-1){
            //throw new Exception ("toUfid not complete: missing ':'"+ufid);
            //System.out.println("toUfid not complete: missing '@'"+ufid);
            return null;
        }
        String guid = ufid.substring( ufid.lastIndexOf(":")+1, ufid.indexOf("@"));
        return guid;
    }
    
    /**
     * Method getObjectIdentifier.
     * @param ufid String
     * @return wt.fc.ObjectIdentifier
     */
    public static ObjectIdentifier getObjectIdentifier(String ufid){
    	String shortOid = getShortOid(ufid);
    	int fi = shortOid.indexOf(":");
		int li = shortOid.lastIndexOf(":");    	
    	if(fi!=li){
			if(shortOid.startsWith("OR:")) shortOid = shortOid.substring(3);
			else return null; 
    	}
		//System.out.println("ObjectIdentifierId: "+shortOid);
    	try {
			return wt.fc.ObjectIdentifier.newObjectIdentifier(shortOid);
		} catch (WTException e) {
			e.printStackTrace();
			return null;
		}
    }
    /**
     * @param ufid 
     * @return String 
     */
    public static String getModelledClassname(String ufid){
    	String shortOid = getShortOid(ufid);
    	int fi = shortOid.indexOf(':');
		int li = shortOid.lastIndexOf(":");    	
		if(fi!=li){
    	    return shortOid.substring(fi+1,li);
    	}else if(li>0){
    	    return shortOid.substring(0,li);
    	}
        return null;
    }

}