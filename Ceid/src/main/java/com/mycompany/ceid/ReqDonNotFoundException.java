package com.mycompany.ceid;
public class ReqDonNotFoundException extends RequestDonationException
{
    public ReqDonNotFoundException()
    {
        super("Your request can not be registered, please try again.");
    }
    public ReqDonNotFoundException(String mess)
    {
        super(mess);
    }
}