package com.mycompany.ceid;



import java.util.ArrayList;
import java.util.List;

public class RequestDonationList{
    
     
   int quantity;
   String id;
   List<RequestDonation> rdEntities=new ArrayList();
   String name;
      
      
   
   
   RequestDonation get(int id){
     return rdEntities.get(id);
            
   }
               
                                
   
void add(RequestDonation rd)
    {
        if(rdEntities.contains(rd))
        {

        }
        else if(! rdEntities.contains(rd))
        {
            RequestDonation requestdonation=new RequestDonation();
            rdEntities.add(requestdonation);
        }

        else
        {
            if(! Organization.Entities.contains(rd))
            {
                throw new IllegalArgumentException();
            }
        }
    }
    public void  remove(String nameInput){
        rdEntities.remove(nameInput);
    }
    
    public void  modify(int newQuantity)
    {
        RequestDonation.quantity=RequestDonation.quantity+newQuantity;
    }
     
    public void  monitor(){
       System.out.println(rdEntities);  
 
}
    public void  reset(){
      rdEntities.clear();
    
    
}
}

