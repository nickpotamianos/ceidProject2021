
package com.mycompany.ceid;

public class Requests extends RequestDonationList {
    Material reqdMaterial;
    Service  reqService;
    Object reqObj;

    public Requests(Object reqObj  ){
         this.reqObj = reqObj;
    }


    public void add(){                           
        if(reqObj instanceof Material){          
        reqObj = (Material) reqObj;
            if( (Material.getDetails()>0) && (Material.getDetails()>0))   {

            }
        } else if(reqObj instanceof Service){    

        }
        else {
            System.out.println("Your request is invalid!");
        }
      
    }

    public void modify(){

    }

    public void validRequestDonation(){

    }

    public void commit(){

    }
}