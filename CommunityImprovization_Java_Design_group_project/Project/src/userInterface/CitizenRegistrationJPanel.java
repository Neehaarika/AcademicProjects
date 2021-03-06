/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Area;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Organization.CitizenOrganization;
import Business.Role.CitizenRole;
import Business.Role.Role;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author mahes
 */
public class CitizenRegistrationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form citizenRegistrationJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem system;

    public CitizenRegistrationJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.system = system;

        populateCombo();

    }

    public void populateCombo() {
        comboNetwork.removeAllItems();
        try {
            for (Network network : system.getNetworkList()) {
                comboNetwork.addItem(network);
            }
        } catch (Exception e) {

        }
    }

    public void populateAreaComboBox(Network network) {
        comboLocation.removeAllItems();
        try {
            for (Area area : network.getAreaList()) {
                comboLocation.addItem(area);
            }
        } catch (Exception e) {

        }

    }

    public void refreshFields() {
        txtName.setText("");
        txtMobile.setText("");
        txtUserName.setText("");
        txtPassword.setText("");
        txtEmail.setText("");
    }

    private boolean checkUserName(String userName) {
        for (Network n : system.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : e.getOrganizationDirectory().getOrganizationList()) {
                    boolean unique = org.getUserAccountDirectory().checkIfUsernameIsUnique(userName);

                    if (!unique) {
                        return false;
                    }
                }
            }

        }
        return true;

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
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        comboNetwork = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMobile = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        comboLocation = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel4.setText("jLabel4");

        setBackground(new java.awt.Color(0, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Register Yourself");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));

        jLabel3.setText("Name:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, -1));

        jLabel5.setText("City:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, -1, -1));

        jLabel7.setText("Mobile:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, -1, -1));
        add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 160, -1));
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 160, -1));

        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 470, -1, -1));

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 470, -1, -1));

        comboNetwork.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNetworkActionPerformed(evt);
            }
        });
        add(comboNetwork, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 160, -1));

        jLabel6.setText("Password:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, -1, -1));

        jLabel8.setText("UserName:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, -1, -1));
        add(txtMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 160, -1));
        add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 160, -1));

        jLabel9.setText("Location:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, -1, -1));

        comboLocation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(comboLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 160, -1));

        jLabel10.setText("with out country code");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 160, -1));
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 160, -1));

        jLabel11.setText("Email:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        if (!txtName.getText().isEmpty() && !txtMobile.getText().isEmpty() && !txtEmail.getText().isEmpty() && !txtUserName.getText().isEmpty() && !txtPassword.getText().isEmpty()) {
            String name = txtName.getText();
            String mobile = txtMobile.getText();
            String email = null;
            String userName = txtUserName.getText();
            String password = txtPassword.getText();
            if (!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", txtEmail.getText()))) {
                JOptionPane.showMessageDialog(null, "Please enter a valid e-mail");
                return;
            } else {
                email = txtEmail.getText();
            }
            Network net = (Network) comboNetwork.getSelectedItem();
            Area area = (Area) comboLocation.getSelectedItem();

            boolean success = false, userNameChecked = false, unique = false;

            for (Network network : system.getNetworkList()) {
                if (network != net) {
                    continue;
                }
                for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                    for (Organization org : ent.getOrganizationDirectory().getOrganizationList()) {

                        if (org instanceof CitizenOrganization) {

                            Role role = null;
                            for (Role r : org.getSupportedRole()) {
                                if (r instanceof CitizenRole) {
                                    role = r;
                                }
                            }

                            if (!userNameChecked) {
                                unique = checkUserName(userName);
                                userNameChecked = true;
                            }

                            if (userNameChecked && unique && role != null) {
                                Employee emp = org.getEmployeeDirectory().createEmployee(name);
                                emp.setArea(area);
                                emp.setMobile(mobile);
                                emp.setEmail(email);
                                UserAccount ua = org.getUserAccountDirectory().createUserAccount(userName, password, emp, role);
                                success = true;
                                refreshFields();
                            }

                        }
                    }
                }
            }

            if (success) {
                JOptionPane.showMessageDialog(this, "Registration processed, close and LogIn", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "UserName already exists or this request is not possible ", "Sorry", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Please enter all the required values", "Sorry", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnRegisterActionPerformed

    private void comboNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNetworkActionPerformed
        // TODO add your handling code here:
        Network network = (Network) comboNetwork.getSelectedItem();

        populateAreaComboBox(network);
    }//GEN-LAST:event_comboNetworkActionPerformed


    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:      
        refreshFields();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRegister;
    private javax.swing.JComboBox comboLocation;
    private javax.swing.JComboBox comboNetwork;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
