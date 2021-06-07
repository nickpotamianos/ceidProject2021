package com.mycompany.ceid;
public class Material extends Entity{
    private final double level1;
    private final double level2;
    private final double level3;
    
    public Material(String name, String description, int id, double level1,
    double level2, double level3){
        super(name,description,id);
        this.level1=level1;
        this.level2=level2;
        this.level3=level3;
    }
    
    public String getDetails(){
        String finall="";
        if(level1==1){
            finall+="One person is entitled! ";}
        if(level2==2){
            finall+="Two-Four persons are entitled! ";}
        if(level3==3)
            finall+="Five+ persons are entitled! ";
            
        return finall+"The level and the object are Materials! ";
    }
}