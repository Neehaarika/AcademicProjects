/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.SchoolRole;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.CSROrganization;
import Business.Organization.CitizenOrganization;
import Business.Organization.Organization;
import Business.Role.ClassVacancy;
import Business.Role.Role;
import Business.Role.SchoolRole;
import Business.UserAccount.UserAccount;
import Business.WorkRequest.EducationFunds;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author mahes
 */
public class PrincipalCreateVacanciesJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PrincipalCreateVacanciesJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Organization organization;
    private Network network;
    private Enterprise enterprise;
    private Role role;
    
    private String[] classNumber={"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII"};
    private String[] Tution={"1000","2000","5000","7000","10000",};
 
    PrincipalCreateVacanciesJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise, Network network) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.organization = organization;
        this.network = network;
        this.enterprise = enterprise;
        this.role= (SchoolRole)userAccount.getRole();
        
        
        populateClasses();
    
        
        
    }
    
    private void populateClasses(){
        comboClass.removeAllItems();
        
        for(int i=0; i<12; i++ ){//((SchoolRole)role).getClassNumber()
            
            comboClass.addItem(classNumber[i]);
        }             
    }
    
     
    
    
    private boolean validation(){
        int vac=0, tution=0;
        try{
            vac = Integer.parseInt(txtVacancies.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Vacancies field must be numeric");
            return false;
        }
        
        try{
            tution = Integer.parseInt(txtTution.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Tution field must be numeric");
            return false;
        }     
      
                
        if( vac > 100 || vac < 0 ){
            JOptionPane.showMessageDialog(null, "Vacancies cannot be more than 100 or not valid");
            return false;
        }
        
        if( (tution % 100 != 0) || (tution < 0) ){
            JOptionPane.showMessageDialog(null, "Tution should be multiple of $1000 and non negative");
            return false;
        }
    
        return true;
    }
    
    private void raiseFunding(){
        Role role=null;
        int funds= ((SchoolRole)role).calculateFunds();
        
        EducationFunds request = new EducationFunds();
        
        request.setReqFunds(String.valueOf(funds));
               
        boolean success=true;
        for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (org instanceof CSROrganization) {
                success = true;
                
                org.getWorkQueue().getWorkRequestList().add(request);
                
            }
            
            if (org instanceof CitizenOrganization) {
                success = true;
                org.getWorkQueue().getWorkRequestList().add(request);
                
            }
        }
        
        userAccount.getWorkQueue().getWorkRequestList().add(request);

        if (success) {
            JOptionPane.showMessageDialog(null, "Success! Funding raised!");
        } else {
            JOptionPane.showMessageDialog(null, "Oops! Something went wrong");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboClass = new javax.swing.JComboBox<>();
        txtVacancies = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtTution = new javax.swing.JTextField();
        lblMsg = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Create or Update Class Vacancies");

        jLabel2.setText("Class :");

        jLabel3.setText("No. of vacancies:");

        comboClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboClassActionPerformed(evt);
            }
        });

        txtVacancies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVacanciesActionPerformed(evt);
            }
        });

        btnCreate.setText("Create/Update");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        jButton1.setText("<<Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Tution/vacancy($):");

        txtTution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTutionActionPerformed(evt);
            }
        });

        lblMsg.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(410, 410, 410)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(lblMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(377, 377, 377)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTution, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtVacancies, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(btnCreate))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(comboClass, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(133, 320, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(lblMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtVacancies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTution, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(88, 88, 88)
                .addComponent(btnCreate)
                .addGap(25, 25, 25)
                .addComponent(jButton1)
                .addContainerGap(114, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtVacanciesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVacanciesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVacanciesActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        if (!validation()) {            
            return;
        }
        
        String c = (String) comboClass.getSelectedItem();
        int vac = Integer.parseInt(txtVacancies.getText());
        int tution =  Integer.parseInt(txtTution.getText());
        
        int currentFund = 0;
        
        ClassVacancy cv=null;
        
        cv= ((SchoolRole)role).searchVacancy(c);
        if(cv==null){
             cv = ((SchoolRole)role).addVacancies(c); 
        }
        
        cv.setClassNumber(c);
        cv.setVacancies(vac);
        cv.setTutionFee(tution);
        
        //raiseFunding();
        
        JOptionPane.showMessageDialog(null, "Class vacancies created/updated for the selected class");
        populateClasses();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
         userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboClassActionPerformed
        // TODO add your handling code here:
        String c = (String) comboClass.getSelectedItem();
        ClassVacancy cv = ((SchoolRole)role).searchVacancy(c);
        
        if(cv!=null){
            lblMsg.setText("Details already added for this class, go ahead if you wish to update");
            txtVacancies.setText(String.valueOf(cv.getVacancies()));
            txtTution.setText(String.valueOf(cv.getTutionFee()));
            
        }else{
            lblMsg.setText("");
            txtVacancies.setText("");
            txtTution.setText("");
            
        }
    }//GEN-LAST:event_comboClassActionPerformed

    private void txtTutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTutionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTutionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JComboBox<String> comboClass;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JTextField txtTution;
    private javax.swing.JTextField txtVacancies;
    // End of variables declaration//GEN-END:variables
}
