package com.mycompany.ceid;

abstract class User
{
    public String name;
    public String phone;
    
    public User (String name, String phone) 
    {
        this.name = name;
        this.phone = phone;
    }
    //getters epeidh exoume private metavlhtes name,phone
    public String getPhone()
    {
        return phone;
    }
    public void setPhone(String phone){this.phone=phone;}
    
    public String getName()
    {
        return name;
    }
    public void setName(String name){this.name=name;}
}