/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author mahes
 */
public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createCrimeOrganization(Organization.CrimeType type) {
        Organization organization = null;
        
        switch (type) {
            case Patrol:                
                organization = new PatrolOrganization();
                organizationList.add(organization);
                break;
            case Police:
                organization = new PoliceOrganization();
                organizationList.add(organization);
                break;
            case Citizen:
                organization = new CitizenOrganization();
                organizationList.add(organization);
                break;
            default:
                break;
        }

        return organization;
    }
    
    public Organization createHealthOrganization(Organization.HealthType type) {
        Organization organization = null;
        
        switch (type) {
            case HealthVolunteer:
                organization = new HealthVolunteerOrganization();
                organizationList.add(organization);
                break;
            case Doctor:
                organization = new DoctorOrganization();
                organizationList.add(organization);
                break;
            case Citizen:
                organization = new CitizenOrganization();
                organizationList.add(organization);
                break;
            case CSR:
                organization = new CSROrganization();
                organizationList.add(organization);
                break;
            default:
                break;
        }

        return organization;
    }
    
    public Organization createEducationOrganization(Organization.EducationType type) {
        Organization organization = null;
        
        switch (type) {
            case EducationVolunteer:
                organization = new EducationVolunteerOrganization();
                organizationList.add(organization);
                break;
            case School:
                organization = new SchoolOrganization();
                organizationList.add(organization);
                break;
            case Citizen:
                organization = new CitizenOrganization();
                organizationList.add(organization);
                break;
            case CSR:
                organization = new CSROrganization();
                organizationList.add(organization);
                break;
            default:
                break;
        }

        return organization;
    }
}
