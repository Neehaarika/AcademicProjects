/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Area;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PoliceOrganization;
import Business.Organization.SchoolOrganization;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import javax.swing.JPanel;
import userInterface.SchoolRole.SchoolPrincipalWorkAreaJPanel;
import userInterface.SchoolRole.SchoolStudentRegWorkAreaJPanel;
import userInterface.SchoolRole.SchoolStudentUnregWorkAreaJPanel;

/**
 *
 * @author mahes
 */
public class SchoolRole extends Role {
    
    private boolean isPrincipal=false;
    private boolean isRegistered=false;
    private Area area;
    
    
    public SchoolRole(){
        super(Role.RoleType.School.getValue());
        
    }    

    public boolean isIsRegistered() {
        return isRegistered;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }


    public void setIsRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }

    public boolean isIsPrincipal() {
        return isPrincipal;
    }

    public void setIsPrincipal(boolean isPrincipal) {
        this.isPrincipal = isPrincipal;
    }
    
  
    //----------------------------------------------------------------------------
    
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,Network network) {
      if(isPrincipal){
          return new SchoolPrincipalWorkAreaJPanel(userProcessContainer, account, (SchoolOrganization)organization,network, enterprise);
      }else if(isRegistered){          
          return new SchoolStudentRegWorkAreaJPanel(userProcessContainer, account, (SchoolOrganization)organization,network, enterprise);
      }else{
          return new SchoolStudentUnregWorkAreaJPanel(userProcessContainer, account, (SchoolOrganization)organization,network, enterprise);
      }
        
    }
}
