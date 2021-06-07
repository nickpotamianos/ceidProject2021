package com.mycompany.ceid;
public class NoValidRequest extends RequestDonationException
{
    
    public NoValidRequest() 
    {
        super("Your request is not a valid one.");
    }
    
    public NoValidRequest(String mess)
    {
        super(mess);
    }
}
