/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author mahes
 */
public abstract class Role {

    private String name;
       
    private ArrayList<ClassVacancy> classVacancies;
    
    
    public Role(String name){    // constructor
        this.name=name;
        classVacancies=new ArrayList<>();
    }
    
    

    public ArrayList<ClassVacancy> getClassVacancies() {
        return classVacancies;
    }
    
    
    public String getName() {    //getter
        return name;
    }
    
    public enum RoleType{
        Admin("Admin"),
        Citizen("Citizen"),
        CSR("CSR"),
        
        Police("Police"),
        Patrol("Patrol"),
        
        HealthVolunteer("HealthVolunteer"),
        School("School"),
        
        
        EducationVolunteer("EducationVolunteer"),
        Doctor("Doctor");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
   
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business,
            Network network);
//----------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return name;
        //return null;
    }
 //----------------------------------------------------------------------------------------------  
    public ClassVacancy addVacancies(String classNum){
        
       /* for(ClassVacancy cv : classVacancies){
            if(cv.getClassNumber().equals(classNum)){
                return cv;
            }
        }*/
        ClassVacancy cv = new ClassVacancy();
        classVacancies.add(cv);
        return cv;
    }
    
    public ClassVacancy searchVacancy(String classNum){
        
        for(ClassVacancy cv : classVacancies){
            if(cv.getClassNumber().equals(classNum)){
                return cv;
            }
        }
        return null;
    }
    
    public int calculateFunds(){
        int total=0;
        for(ClassVacancy cv : classVacancies){
            total= total + cv.getTutionFee()*cv.getVacancies();
        }
        return total;
    }
    
    
}