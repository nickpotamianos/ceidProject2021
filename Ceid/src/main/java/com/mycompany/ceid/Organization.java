package com.mycompany.ceid;
import java.util.ArrayList;
import java.util.List;

public class Organization{
    Admin admin;
    String orgName;
    static List donators=new ArrayList();
    static List beneficiary=new ArrayList();

    public static List<Entity> Entities=new ArrayList<Entity>();      
    RequestDonationList currentDonations;
    double quantity;
   
         

    //setAdmin methodos
    public organization getName(){
        return orgName;
    }
    public organization getCurrentDoantions(){
        return currentDonations;
    }
    
    public void setAdmin (String adminName, String adminPhone){ 
  
    
    Admin admin=new Admin(adminName, adminPhone);
    admin.isAdmin=true;
    }
    //getAdmin methodos
    public Admin getAdmin(){
    return admin; 
    }
    //addEnity methodos gia material
    public void addEntity(String entityName,String entityDescription,int entityId,double entityLevel1,double entityLevel2,double entityLevel3){
Material material = new Material(entityName,entityDescription,entityId,entityLevel1,entityLevel2,entityLevel3);
Entities.add(entityId,material);
    }
    
    //addEntity methodos gia services
   public void addEntity(String serviceName, String serviceDescription,int serviceId){
       Service service=new Service(serviceName, serviceDescription,serviceId );
       Entities.add(serviceId,service);

   } 
       
   
    //removeEntity methodos
    public static void removeEntity(String ename){
        Entities.remove(ename);
        
    }
    //insertDonator methodos
     public void insertDonator(String donorName, String donorPhone){
         
         Donator don=new Donator(donorName,donorPhone);
         don.name=donorName;
         don.phone=donorPhone;
         donators.add(don);   
         
         
        
    }
    //removeDonator methodos 
    public static void removeDonator(String donorName){
        donators.remove(donorName);
      
        
    }
    //insertBeneficiary methodos
    public void insertBeneficiary(String benName,String benPhone){
        
         Beneficiary ben=new Beneficiary(benName,benPhone);
         ben.name=benName;
         ben.phone=benPhone;
         beneficiary.add(ben);
         
    }
    //removeBeneficiary methodos
    public static void removeBeneficiary(String benName){
       beneficiary.remove(benName); 
    }
    //listEntiries methodos
    public static void listEntities(){
       System.out.println(Entities); 
    }
    
    //listBeneficiaries methodos
    public static void listBeneficiaries(){
      System.out.println(beneficiary);  
    }
    //listDonators methodos
    public static organization listDonators(){
    System.out.println(donators);
    return donators;
    
}
}
