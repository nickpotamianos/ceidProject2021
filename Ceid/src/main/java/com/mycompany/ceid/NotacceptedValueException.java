package com.mycompany.ceid;
import java.lang.Exception;
public class NotacceptedValueException extends Exception{
    public NotacceptedValueException()
    {
        super("The given value can not be accepted at all.");
    }
    
    public NotacceptedValueException(String mess)
    {
        super();
    }
    //kapoia eidopoihsh apo menu
}



