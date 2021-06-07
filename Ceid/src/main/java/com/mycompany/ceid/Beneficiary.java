package com.mycompany.ceid;
import java.util.ArrayList;

public class Beneficiary extends User
{   
    private int noPersons = 1;
    private RequestDonationList receivedList = new RequestDonationList();
    private Requests requestsList = new Requests(this);
    
    
    public Beneficiary(String name, String phone)
    {    
        super(name, phone);
    }
    
    public RequestDonationList getReceivedList()
    {
        return receivedList;
    }
    
    public void addReceived(RequestDonation rd) throws RequestDonationException //Throws RequestDonationNotFoundException 
    {                                                                        //se periptwsh poy den vrethei to "rd.entity" sthn "Organization.entityList"
        receivedList.add(rd);
    }
    
    public void modifyReceived(int id, double quantity) throws RequestDonationException //Throws RequestDonationNotFoundException 
    {                                                               //an den yparxei RequestDonation me id sthn "receivedList".
        receivedList.modify(id, quantity);
    }
    
    public void removeReceived(int id) throws RequestDonationException //Throws RequestDonationNotFoundException 
    {                                                                   //an den vrethei RequestDonation me to id sthn "receivedList".
        receivedList.remove(id);
    }
    
    public String monitorReceived()
    {
        return "The received requests\n" + receivedList.monitor();
    }
    
    public void resetReceivedList()
    {
        receivedList.reset();
    }
    
    public Requests getRequestsList()
    {
        return requestsList;
    }
    
    public void addRequest(RequestDonation rd) throws RequestDonationException //See add() in class Requests for exception handling.
    {
        requestsList.add(rd);
    }
    
    public void modifyRequest(int id, double quantity) throws RequestDonationException //See modify() in class Requests for exception handling.
    {
        requestsList.modify(id, quantity);
    }
    
    public void removeRequest(int id) throws RequestDonationException //Throws RequestDonationNotFoundException 
    {                                                                 //if no RequestDonation with the id is found in "requestsList".
        requestsList.remove(id);
    }
    
    public String monitorRequests()
    {
        return "The current requests\n" + requestsList.monitor();
    }
    
    public void commitRequests()
    {
        requestsList.commit();
    }
    
    public void resetRequests()
    {
        requestsList.reset();
    }
    public int getNoPersons()
    {
        return noPersons;
    }

    public void setNoPersons(int noPersons)
    {
        this.noPersons = noPersons;
    }
}