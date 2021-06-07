package com.mycompany.ceid;
import java.lang.Exception;
public class LimitExcessException extends RequestDonationException
{
    private String mess = "That's too much to ask!";
    
    public LimitExcessException() 
    {
        super();
    }
    
    public LimitExcessException(String mess)
    {
        super(mess);
    }
}
   