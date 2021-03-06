/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.SchoolRole;

import Business.Enterprise.Enterprise;
import Business.Network.Area;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.SchoolOrganization;
import Business.Role.SchoolRole;
import Business.UserAccount.UserAccount;
import Business.WorkRequest.EduVolToSchoolWorkRequest;
import Business.WorkRequest.WorkRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mahes
 */
public class SchoolStudentRegWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SchoolStudentRegWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Organization organization;
    private Network network;
    private Enterprise enterprise;
    private Area area;
    private String status="Admission Requested";

    public SchoolStudentRegWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, 
            Organization organization, Network network, Enterprise enterprise) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.organization = organization;
        this.network = network;
        this.enterprise=enterprise;
        this.area=((SchoolRole)userAccount.getRole()).getArea();
        //System.out.p{rintln(area.getName()+"------*-");
        if(area!=null){
           lblLocation.setText(area.getName());        
           populateTable(area); 
        }else{
            lblLocation.setText("");
        }
        
    }
    
    private void populateTable(Area area) {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();

        model.setRowCount(0);

        for (WorkRequest wr : organization.getWorkQueue().getWorkRequestList()) {

            if (!(wr instanceof EduVolToSchoolWorkRequest)) {
                continue;
            }

            if (!((EduVolToSchoolWorkRequest) wr).getArea().equals(area)) {
                continue;
            }

            Object[] row = new Object[7];

            row[0] = ((EduVolToSchoolWorkRequest) wr).getSurveyID();
            row[1] = ((EduVolToSchoolWorkRequest) wr);
            row[2] = ((EduVolToSchoolWorkRequest) wr).getAge();
            row[3] = ((EduVolToSchoolWorkRequest) wr).getEduStatus();
            row[4] = ((EduVolToSchoolWorkRequest) wr).getEduHighest();
            row[5] = ((EduVolToSchoolWorkRequest) wr).getSender();
            row[6] = ((EduVolToSchoolWorkRequest) wr).getStatus();

            model.addRow(row);
            

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

        lblHeader = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblLocation = new javax.swing.JLabel();
        btnAdm = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("STUDENT WORK AREA");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Educational Camp Registered Student");

        lblLocation.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblLocation.setText("<empty>");

        btnAdm.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnAdm.setText("Request Admission");
        btnAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmActionPerformed(evt);
            }
        });

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Survey ID", "Name", "Age", "Education Status", "Highest Edu Level", "Sender", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 744, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(373, 373, 373)
                                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(439, 439, 439)
                                .addComponent(btnAdm)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(lblLocation)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btnAdm)
                .addContainerGap(106, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbl.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a valid row");
            return;
        }
        
        
        
        EduVolToSchoolWorkRequest ewr = (EduVolToSchoolWorkRequest) tbl.getValueAt(selectedRow, 1);
        
        ewr.setStatus(status);
        
        populateTable(area);
        
        JOptionPane.showMessageDialog(null, "Admission requested placed to principal");
        
    }//GEN-LAST:event_btnAdmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables
}
