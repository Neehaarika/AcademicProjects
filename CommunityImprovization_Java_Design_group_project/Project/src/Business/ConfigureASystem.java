/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Employee.Employee;
import Business.Network.Area;
import Business.Network.Network;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author mahes    //branched to aravind
 */
public class ConfigureASystem {

    public static EcoSystem configure() {
        
        EcoSystem system = EcoSystem.getInstance();
        
        Network network = system.createAndAddNetwork();
        network.setName("Boston");
        Area area1 = network.createANewArea("BackBay");
        Area area2 = network.createANewArea("Roxbury");
        Area area3 = network.createANewArea("Fenway");
        
        Network network2 = system.createAndAddNetwork();
        network2.setName("NewYork");
        Area area4 = network2.createANewArea("Times Square");
        Area area5 = network2.createANewArea("Manhattan");
        Area area6 = network2.createANewArea("Central Park");
        
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        Employee employee = system.getEmployeeDirectory().createEmployee("Admin");
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        
        return system;
    }
    
}
