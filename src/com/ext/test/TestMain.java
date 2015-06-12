package com.ext.test;
import wt.fc.PersistenceHelper;
import wt.fc.QueryResult;
import wt.org.OrganizationServicesHelper;
import wt.org.WTPrincipal;
import wt.part.WTPart;
import wt.query.QueryException;
import wt.query.QuerySpec;
import wt.util.WTException;
public class TestMain {

	public static void main(String[] args) {
		//testPart();
		//testInitUser();
	}
	public static void testPart() {
		try {
			QuerySpec qs = new QuerySpec(WTPart.class);
			QueryResult qr  = PersistenceHelper.manager.find(qs);
			while(qr.hasMoreElements()){
				WTPart part = (WTPart)qr.nextElement();
				System.out.println("Part "+part.getNumber()+ 
						" " + part.getName()+
						" " + part.getVersionInfo().getIdentifier().getValue() + 
						"." + part.getIterationInfo().getIdentifier().getValue());
				
			}
			} catch (QueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public static void testInitUser(){
		try {
			WTPrincipal user =  OrganizationServicesHelper.manager.getPrincipalByDN("cn=Usr02,ou=people,cn=AdministrativeLdap,cn=Windchill_10.2,o=ptc", null, true);
			
			if(user!=null){
			     System.out.println("user db = "+ user.getDn() + "\t name = " + user.getName());
			}
		} catch (WTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
