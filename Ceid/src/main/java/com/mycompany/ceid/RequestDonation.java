package com.mycompany.ceid;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.ArrayList;
public class RequestDonation implements Comparator<Entity>{
    Entity entity;
    static double quantity;
    
    /*User ex1=new User("ex","h2o",1);
    User ex2=new User("ex2","ho",1);*/
    public int compare(Entity ex1, Entity ex2){
        if(ex1.getid()==ex2.getid())
            return 0;
        else if(ex1.getid()>ex2.getid())
            return 1;
        else 
            return -1;
    }
    
    ArrayList<Entity> RD = new ArrayList<Entity>();
    
    public void addEntity(Entity a){
        RD.add(a);
    }
    
    public void getList(){
      for (Entity item : RD){
           System.out.println(item.getEntityInfo());
      }
    }
}