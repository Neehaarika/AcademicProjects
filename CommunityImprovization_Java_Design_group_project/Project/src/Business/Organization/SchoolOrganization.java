/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CitizenRole;
import Business.Role.Role;
import Business.Role.SchoolRole;
import java.util.ArrayList;

/**
 *
 * @author mahes
 */
public class SchoolOrganization extends Organization{
    public SchoolOrganization() {
        super(EducationType.School.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> supportedRoles = new ArrayList<Role>();
        supportedRoles.add(new SchoolRole());
        return supportedRoles;
    }
}