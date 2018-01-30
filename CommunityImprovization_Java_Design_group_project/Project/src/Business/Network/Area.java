/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

/**
 *
 * @author pruth
 */
public class Area {
    private String name;
    private int zipcode;
    //
    private boolean camp=false;
    private boolean campFull=false;
    private int numberFilled;
    private int numberPerCamp;
    

    public boolean isCampFull() {
        return campFull;
    }

    public void setCampFull(boolean campFull) {
        this.campFull = campFull;
    }

    public int getNumberFilled() {
        return numberFilled;
    }

    public void setNumberFilled(int numberFilled) {
        this.numberFilled = numberFilled;
    }
    
    
    public Area(String name){
        this.name=name;
    }

    public boolean isCamp() {
        return camp;
    }

    public void setCamp(boolean camp) {
        this.camp = camp;
    }

    public int getNumberPerCamp() {
        return numberPerCamp;
    }

    public void setNumberPerCamp(int numberPerCamp) {
        this.numberPerCamp = numberPerCamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public void incrementFilled(){
        this.numberFilled++;
    }
    
    @Override
    public String toString() {
        return this.name; 
    }
    
    
    
}
