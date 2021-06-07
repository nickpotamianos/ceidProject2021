package com.mycompany.ceid;
import java.lang.Exception;
public class RequestDonationException extends Exception
{
    public RequestDonationException()
    { super("Your request can not be registered, please try again.");
        
    }
    public RequestDonationException(String mess)
    {
       super(mess);     

    }
    
    //kapoiou eidous eidopoihsh/enhmerwsh gia otan ginetai ayto apo thn klash menu
}