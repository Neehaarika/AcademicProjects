/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import static Business.Enterprise.Enterprise.EnterpriseType.*;
import Business.Network.Network;
import Business.Organization.CSROrganization;
import Business.Organization.Organization;
import Business.Organization.PoliceOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import userInterface.CSRRole.CSREducationWorkAreaJPanel;
import userInterface.CSRRole.CSRHealthWorkAreaJPanel;
import userInterface.PoliceRole.PoliceWorkAreaJPanel;

/**
 *
 * @author mahes
 */
public class CSRRole extends Role {

    public CSRRole() {
        super(Role.RoleType.CSR.getValue());
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization,
            Enterprise enterprise, EcoSystem business, Network network) {
        
        switch (enterprise.getEnterpriseType()) {
            case Health:
                return new CSRHealthWorkAreaJPanel(userProcessContainer, account, (CSROrganization) organization, network);
            case Education:
                return new CSREducationWorkAreaJPanel(userProcessContainer, account, (CSROrganization) organization, network);
            default:
                JOptionPane.showMessageDialog(null, "Unexpected error, CSR");
                return null;
        }        
    }
}
