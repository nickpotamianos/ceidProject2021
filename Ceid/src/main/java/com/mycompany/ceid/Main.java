package com.mycompany.ceid;

public class Main{
public static void main(String[] args){
    Organization org=new Organization("Usicef","James","40431541460");
    org.addEntity("orange juice","good for kids",120,1.0,0.0,0.0);
    org.addEntity("vegetables","good for your health",121,0.0,2.0,0.0);
    org.addEntity("Fried Chicken","delicious",123,0.0,0.0,3.0);
    org.addEntity("Medical Support","for every need of medicine",124);
    org.addEntity("Phychological Supprot","for every need",125);
    org.addEntity("Education","The Best",126);
    org.addEntity("Information for Covid-19","The Best",126);
    /*Entity ex1=new Material("ex1","h2o",1,1.0,0.0,0.0);
    Entity ex2=new Service("ex2","h2o",1,0.0,1.0,0.0);
    User ex1=new User("ex","h2o",1);
    User ex2=new User("ex2","ho",1);*/
    Admin ad=new Admin("Alexis","698535152");
    Beneficiary b1=new Beneficiary("Jonh","6986963651");
    Beneficiary b2=new Beneficiary("Natalie","6985452587");
    Donator d1=new Donator("Mike","456987");
    Menu menu=new Menu();
    menu.start(org);
    }
}