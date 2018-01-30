/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkRequest.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author mahes
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter;

    
    public enum CrimeType{
        Patrol("Patrol Organization"), Police("Police Organization"), Citizen("citizen Organization");
        private String value;
        private CrimeType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public enum HealthType{
        Citizen("citizen Organization"),HealthVolunteer("HealthVolunteer Organization"), Doctor("Doctor Organization"), CSR("CSR organization");
        private String value;
        private HealthType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public enum EducationType{
        Citizen("citizen Organization"),EducationVolunteer("EducationVolunteer Organization"), School("School Organization"), CSR("CSR organization");
        private String value;
        private EducationType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}