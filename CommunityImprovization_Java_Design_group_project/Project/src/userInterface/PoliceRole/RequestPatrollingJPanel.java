/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.PoliceRole;

import Business.Enterprise.Enterprise;
import Business.Network.Area;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PatrolOrganization;
import Business.Organization.PoliceOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkRequest.PoliceToPatrolWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author pruth
 */
public class RequestPatrollingJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RequestPatrollingJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Network network;
    private Enterprise enterprise;
    public RequestPatrollingJPanel(JPanel userProcessContainer, UserAccount userAccount,Enterprise enterprise, Network network) {
        initComponents();
        this.userAccount=userAccount;
        this.userProcessContainer=userProcessContainer;
        this.network=network;
        this.enterprise=enterprise;
        lblNetwork.setText(network.getName());
        populateAreaComboBox();       
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
        lblNetwork = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboArea = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtNoofVans = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnRequest = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 153, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REQUEST PATROLLING");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 16, 528, -1));

        jLabel2.setText("Network");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 111, 144, -1));
        add(lblNetwork, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 111, 141, 20));

        jLabel3.setText("Area");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 152, 144, -1));

        comboArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAreaActionPerformed(evt);
            }
        });
        add(comboArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 149, 141, -1));

        jLabel4.setText("No.of vans Required");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 196, -1, -1));
        add(txtNoofVans, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 193, 141, -1));

        btnBack.setText("<<HEAD BACK TO PREVIOUS PAGE");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 73, 315, -1));

        btnRequest.setText("Request");
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });
        add(btnRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 235, 152, -1));
    }// </editor-fold>//GEN-END:initComponents

    public void populateAreaComboBox(){
        comboArea.removeAllItems();
        try {
            for (Area area : network.getAreaList()) {
                comboArea.addItem(area);
            }
        } catch (Exception e) {

        }
    }
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        PoliceWorkAreaJPanel panel = (PoliceWorkAreaJPanel) component;
        panel.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        // TODO add your handling code here:
        int vansRequested=Integer.parseInt(txtNoofVans.getText());
        Area area=(Area) comboArea.getSelectedItem();
        
        PoliceToPatrolWorkRequest patrolRequest=new PoliceToPatrolWorkRequest();
        patrolRequest.setVansRequested(vansRequested);
        patrolRequest.setArea(area);
        patrolRequest.setSender(userAccount);
        patrolRequest.setStatus("Sent to Patrolling");
        patrolRequest.setMessage(String.valueOf(vansRequested));
        
        Organization org=null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof PatrolOrganization) {
                    org = organization;
                    break;
                }
            }
        
        if (org != null) {
            org.getWorkQueue().getWorkRequestList().add(patrolRequest);
            userAccount.getWorkQueue().getWorkRequestList().add(patrolRequest);
            
        }
        txtNoofVans.setText("");
        JOptionPane.showMessageDialog(this, "REQUEST SENT TO PATROL DEPARTMENT", "SUCCESS!!", JOptionPane.INFORMATION_MESSAGE);
          
    }//GEN-LAST:event_btnRequestActionPerformed

    private void comboAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAreaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_comboAreaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRequest;
    private javax.swing.JComboBox comboArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblNetwork;
    private javax.swing.JTextField txtNoofVans;
    // End of variables declaration//GEN-END:variables
}