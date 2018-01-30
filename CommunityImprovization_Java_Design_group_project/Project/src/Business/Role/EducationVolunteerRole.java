/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.EducationVolunteerOrganization;
import Business.Organization.Organization;
import Business.Organization.PoliceOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.EducationVolunteerRole.EducationVolunteerWorkAreaJPanel;

/**
 *
 * @author mahes
 */
public class EducationVolunteerRole extends Role{
    
    public EducationVolunteerRole(){
        super(Role.RoleType.EducationVolunteer.getValue());
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,Network network) {
      
        return new EducationVolunteerWorkAreaJPanel(userProcessContainer, account, (EducationVolunteerOrganization)organization,network,enterprise);
    }
}
