/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PoliceOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.PoliceRole.PoliceWorkAreaJPanel;

/**
 *
 * @author pruth
 */
public class PoliceRole extends Role{
    
    public PoliceRole(){
        super(Role.RoleType.Police.getValue());
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,Network network) {
      
        return new PoliceWorkAreaJPanel(userProcessContainer, account, (PoliceOrganization)organization,enterprise,network);
    }
}
