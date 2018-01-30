/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequest;

import Business.Network.Area;
import Business.Network.Network;

/**
 *
 * @author aravind
 */
public class VolunteerToDoctor  extends WorkRequest{
    
     private static int count=1;
    private int patientID;
    private String name;
   // private Area area;
   // private Network network;
    private String disease;
    private String duration;
    private String contact;
    private String CSRName;
    private String email;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        VolunteerToDoctor.count = count;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    public VolunteerToDoctor() {
        patientID=count;
        count++;
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPatientID() {
        return patientID;
    }

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCSRName() {
        return CSRName;
    }

    public void setCSRName(String CSRName) {
        this.CSRName = CSRName;
    }
    
    
      @Override
    public String toString() {
        return this.name; //To change body of generated methods, choose Tools | Templates.
    }
}
