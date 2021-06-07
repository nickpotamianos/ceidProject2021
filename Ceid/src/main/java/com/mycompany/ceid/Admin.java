package com.mycompany.ceid;
public class Admin extends User
{
    boolean isAdmin= true ;
    
    public Admin(String name, String phone)
    {
        super(name, phone);
    }
    //afoy einai diaxeirisths thelei prosvash se stoixeia systhmatos
    public void  ListBeneficiaries() {}
    
    public void ListDonators() {}
    
    
}