/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.CSRRole;

import Business.Enterprise.Enterprise;
import Business.Network.Area;
import Business.Network.Network;
import Business.Organization.CSROrganization;
import Business.Organization.Organization;
import Business.Role.ClassVacancy;
import Business.Role.Role;
import Business.Role.SchoolRole;
import Business.UserAccount.UserAccount;
import Business.WorkRequest.EduVolToSchoolWorkRequest;
import Business.WorkRequest.EducationFunds;
import Business.WorkRequest.WorkRequest;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author mahes
 */
public class CSREducationWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CSREducationWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Organization organization;
    private Network network;
    private Enterprise enterprise;
    private ArrayList<Area> areaList;
    private Role role;
    private ArrayList<WorkRequest> requestList;

    public CSREducationWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Network network) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.organization = (CSROrganization)organization;
        this.network = network;
        this.enterprise=enterprise;
        this.areaList=network.getAreaList();
        this.role= (SchoolRole)role;
        
        requestList=account.getWorkQueue().getWorkRequestList();
        
       populateData();
       
    }
    
    
   private void populateData(){
        for(WorkRequest request : requestList){
            if(!(request instanceof EducationFunds)){
                continue;
            }
            String total=((EducationFunds)request).getReqFunds();
            String collected = ((EducationFunds)request).getCollectedFunds();
            
            lblTotal.setText(total);
            lblCollected.setText(collected);
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
        lblTotal = new javax.swing.JLabel();
        lblCollected = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboDonation = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("CSR WORK AREA");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 108, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Total Fund Required($):");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Total Fund Collected($):");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, -1, -1));
        add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 97, 16));
        add(lblCollected, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, 97, 16));

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 15)); // NOI18N
        jLabel4.setText("Your Donation($):");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 149, -1));

        comboDonation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(comboDonation, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, 131, -1));

        jButton1.setText("Donate");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(557, 490, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboDonation;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblCollected;
    private javax.swing.JLabel lblTotal;
    // End of variables declaration//GEN-END:variables
}
