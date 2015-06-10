package com.acme;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import wt.fc.PersistenceHelper;
import wt.util.WTException;
import wt.util.WTPropertyVetoException;

public class TestMain {

    public static void main(String[] args) {
        Pet myPet;
        try {
            myPet = Pet.newPet();
            myPet.setName("Fergus");
            myPet.setKind(PetKind.toPetKind("cat"));
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            Timestamp ts = new Timestamp(df.parse("1999-12-30").getTime());
            myPet.setDateOfBirth(ts);
            myPet.setFixed(true);
            PersistenceHelper.manager.save(myPet);
            
            
           
        } catch (WTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (WTPropertyVetoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      
       
    }

}
