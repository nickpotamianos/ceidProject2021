package com.mycompany.ceid;

import java.util.ArrayList;
import java.util.List;



public class Offers extends RequestDonationList{
    
        
    public void commit(){
        ArrayList<RequestDonation> currentDonations=new ArrayList<RequestDonation>();
    for (RequestDonation rd: rdEntities){
        currentDonations.add(rd);
        rdEntities.remove(rd);
     
        
    }
    
    
    
    
}
}

