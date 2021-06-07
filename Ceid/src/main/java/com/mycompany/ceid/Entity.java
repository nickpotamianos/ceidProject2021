package com.mycompany.ceid;
abstract class Entity{
    private String name;
    private String description;
    public int id;
    
    public Entity(String name, String description, int id){
        this.name=name;
        this.description=description;
        this.id=id;
    }
    //Setters και getters 
    public String getname(){return name;}
    public void setname(String name){this.name=name;}
    
    public String getdescription(){return description;}
    public void setdescription(String description){this.description=description;}
    
    public int getid(){return id;}
    //public void setid(String id){this.id=id;}
    
    public String getEntityInfo(){
        return ("Name is "+this.getname()+", description: "+this.getdescription()+
        "and id "+this.getid());
    }
    
    abstract String getDetails();
    
    public String toString(){
        return (this.getEntityInfo()+this.getDetails());
    }
}