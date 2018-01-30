/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Enterprise.EnterpriseType;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.CitizenRole.CitizenCrimeWorkArea;
import userInterface.CitizenRole.CitizenEducationWorkArea;
import userInterface.CitizenRole.CitizenHealthWorkArea;


/**
 *
 * @author pruth
 */
public class CitizenRole extends Role{
    
    public CitizenRole(){
        super(Role.RoleType.Citizen.getValue());
    }

    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,Network network) {
        Enterprise.EnterpriseType e = enterprise.getEnterpriseType();        
        
        switch(e){
            case Crime:
               return new CitizenCrimeWorkArea(userProcessContainer, account,organization, enterprise, business,network); 
               
            case Health:
                return new CitizenHealthWorkArea(userProcessContainer, account, organization, enterprise, business,network); 
                
            case Education:
                return new CitizenEducationWorkArea(userProcessContainer, account,organization, enterprise, business,network); 
                
            default:   
                break;
        }
        return null;
        
    }
    
    
}
