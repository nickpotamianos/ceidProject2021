package com.mycompany.ceid;
public class Donator extends User
{
    private Offers offersList = new Offers(this);
     
    public Donator(String name, String phone)
    {
        super(name, phone);
    }
     
    public void addOffer(RequestDonation rd) throws RequestDonationException //Throws RequestDonationNotFoundException 
    {                                                                        //se periptwsh poy den vrethei to "rd.entity" sthn "Organization.entityList".
    offersList.add(rd);
    }
    
    public void removeOffer(int id) throws RequestDonationException //Throws RequestDonationNotFoundException 
    {                                                               //an den yparxei RequestDonation me id sthn "offersList".
        offersList.remove(id);
    }
    
    public void modifyOffer(int id, double quantity) throws RequestDonationException //Throws RequestDonationNotFoundException 
    {                                                                                //an den vrethei RequestDonation me to id sthn "offersList".
        offersList.modify(id, quantity);
    }
    
    public String monitorOffers()
    {
        return "The current offers\n" + offersList.monitor();
    }
    
    public void commitOffers()
    {
        offersList.commit();
    }
    
    public void resetOffers()
    {
        offersList.reset();
    }
    
    public Offers getOffersList()
    {
        return offersList;
    }
}