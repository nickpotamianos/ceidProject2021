package com.mycompany.ceid;
import java.lang.Exception;
public class AlreadyExistsException extends Exception
{
    
    public AlreadyExistsException()
    {
       super("Already exists");
    }
    
    public AlreadyExistsException(String mess)
    {
        super();
    }
    //kapoiou eidous eidopoihsh/enhmerwsh gia otan ginetai ayto apo thn klash menu
    
}