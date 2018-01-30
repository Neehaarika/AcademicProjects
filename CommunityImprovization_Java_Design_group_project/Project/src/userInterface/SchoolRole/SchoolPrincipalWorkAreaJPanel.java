/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.SchoolRole;

import Business.Enterprise.Enterprise;
import Business.Network.Area;
import Business.Network.Network;
import Business.Organization.CSROrganization;
import Business.Organization.CitizenOrganization;
import Business.Organization.Organization;
import Business.Organization.SchoolOrganization;
import Business.Role.ClassVacancy;
import Business.Role.Role;
import Business.Role.SchoolRole;
import Business.UserAccount.UserAccount;
import Business.WorkRequest.EduVolToSchoolWorkRequest;
import Business.WorkRequest.EducationFunds;
import Business.WorkRequest.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import userInterface.CitizenJPanel;

/**
 *
 * @author mahes
 */
public class SchoolPrincipalWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SchoolWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Organization organization;
    private Network network;
    private Enterprise enterprise;
    
    private String bar="Bar Chart Analysis", pie="Pie Chart Analysis";

    public SchoolPrincipalWorkAreaJPanel(JPanel userProcessContainer, UserAccount account,
            Organization organization, Network network, Enterprise enterprise) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.organization = organization;
        this.network = network;
        this.enterprise = enterprise;
        
        btnFunds.setVisible(false);
        
        loadComboLiteracy();
        comboLiteracy.setVisible(false);

        lblNetwork1.setText(network.getName());
        lblNetwork2.setText(network.getName());
        lblNetwork3.setText(network.getName());
    }

    public void displayChart() {
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
        for (Area area : network.getAreaList()) {
            float percentage = 0; 
            int count = 0, literates = 0;

            for (WorkRequest wr : organization.getWorkQueue().getWorkRequestList()) {
                if (!(wr instanceof EduVolToSchoolWorkRequest)) {
                    continue;
                }

                Area a = ((EduVolToSchoolWorkRequest) wr).getArea();
                if (!a.equals(area)) {
                    continue;
                }

                if (((EduVolToSchoolWorkRequest) wr).isLiterate()) {
                    literates++;
                }
                count++;

            }

            percentage = (( literates* 100/count ) );
            dcd.addValue(percentage, "Literacy Rates", area.getName());
        }

        JFreeChart chart = ChartFactory.createBarChart("Bar Chart", "Area", "Literacy %", dcd);
        CategoryPlot plot = chart.getCategoryPlot();

        ChartFrame chrt = new ChartFrame("Literacy", chart);
        chrt.setVisible(true);
        chrt.setSize(500, 400);
        
        loadComboLiteracy();
    }
    
    public void displayPie(){
        DefaultPieDataset dpd = new DefaultPieDataset();
        
        for (Area area : network.getAreaList()) {
            float percentage = 0; 
            int count = 0, literates = 0;

            for (WorkRequest wr : organization.getWorkQueue().getWorkRequestList()) {
                if (!(wr instanceof EduVolToSchoolWorkRequest)) {
                    continue;
                }

                Area a = ((EduVolToSchoolWorkRequest) wr).getArea();
                if (!a.equals(area)) {
                    continue;
                }

                if (((EduVolToSchoolWorkRequest) wr).isLiterate()) {
                    literates++;
                }
                count++;

            }

            percentage = (( literates* 100/count ) );
            dpd.setValue(area.getName(), percentage);
        }
        
        JFreeChart chart = ChartFactory.createPieChart(network.getName() +" " +"Literacy Rates", dpd, true, true, true);
        PiePlot p = (PiePlot) chart.getPlot();
        p.setSimpleLabels(true);

        ChartFrame c = new ChartFrame("Pie Chart", chart);
        c.setVisible(true);
        c.setSize(400, 500);
        
        loadComboLiteracy();
    }

    private void loadComboLiteracy(){
        comboLiteracy.removeAllItems();
        comboLiteracy.addItem("Select");
        
        comboLiteracy.addItem(bar);
        comboLiteracy.addItem(pie);
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
        lblNetwork1 = new javax.swing.JLabel();
        btnSurvey = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblNetwork2 = new javax.swing.JLabel();
        btnLiteracy = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnVacancies = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblNetwork3 = new javax.swing.JLabel();
        btnCamps = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnRegistration = new javax.swing.JButton();
        comboLiteracy = new javax.swing.JComboBox<>();
        btnFunds = new javax.swing.JButton();

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("PRINCIPAL WORK AREA");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("See Survey Details in");

        lblNetwork1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNetwork1.setText("<empty>");

        btnSurvey.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSurvey.setText("Survey Results");
        btnSurvey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSurveyActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("See Literacy Rates in");

        lblNetwork2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNetwork2.setText("<empty>");

        btnLiteracy.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnLiteracy.setText("Literacy Rates");
        btnLiteracy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLiteracyActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Setup Class Vacancies");

        btnVacancies.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnVacancies.setText("Create Vacancies");
        btnVacancies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVacanciesActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Organize camps in");

        lblNetwork3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNetwork3.setText("<empty>");

        btnCamps.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnCamps.setText("Organize Camps");
        btnCamps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCampsActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Manage Registered people ");

        btnRegistration.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnRegistration.setText("Manage Admissions");
        btnRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrationActionPerformed(evt);
            }
        });

        comboLiteracy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboLiteracy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboLiteracyActionPerformed(evt);
            }
        });

        btnFunds.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnFunds.setText("Request Funds");
        btnFunds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFundsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(455, 455, 455)
                        .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(386, 386, 386)
                        .addComponent(jLabel1)
                        .addGap(7, 7, 7)
                        .addComponent(lblNetwork1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnSurvey, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(385, 385, 385)
                        .addComponent(jLabel4)
                        .addGap(7, 7, 7)
                        .addComponent(lblNetwork3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(btnCamps, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(385, 385, 385)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(btnVacancies, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(386, 386, 386)
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addComponent(lblNetwork2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnLiteracy, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(comboLiteracy, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(jLabel5)
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFunds, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSurvey)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblNetwork1))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lblNetwork2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLiteracy)
                            .addComponent(comboLiteracy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCamps)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(lblNetwork3))))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3))
                    .addComponent(btnVacancies))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel5))
                    .addComponent(btnRegistration))
                .addGap(41, 41, 41)
                .addComponent(btnFunds)
                .addContainerGap(71, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrationActionPerformed
        // TODO add your handling code here:
        comboLiteracy.setVisible(false);
        
        PrincipalManageRegistrationJPanel panel = new PrincipalManageRegistrationJPanel(userProcessContainer, userAccount,
                organization, enterprise, network);
        userProcessContainer.add("PrincipalManageRegistrationJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnRegistrationActionPerformed

    private void btnSurveyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSurveyActionPerformed
        // TODO add your handling code here:
        comboLiteracy.setVisible(false);
        
        PricipalSurveyResultsJPanel panel = new PricipalSurveyResultsJPanel(userProcessContainer, userAccount,
                organization, enterprise, network);
        userProcessContainer.add("PricipalSurveyResultsJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_btnSurveyActionPerformed

    private void btnLiteracyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLiteracyActionPerformed
        // TODO add your handling code here:
        comboLiteracy.setVisible(true);
    }//GEN-LAST:event_btnLiteracyActionPerformed

    private void comboLiteracyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboLiteracyActionPerformed
        // TODO add your handling code here:\
        String s =(String) comboLiteracy.getSelectedItem();
        
        if(s==null){
            return;
        }
        
        if(s.equals(bar)){
            displayChart();
        }
        
        if(s.equals(pie)){
            displayPie();
        }
        
    }//GEN-LAST:event_comboLiteracyActionPerformed

    private void btnCampsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCampsActionPerformed
        // TODO add your handling code here:
        comboLiteracy.setVisible(false);
        
        PrincipalCampJPanel panel = new PrincipalCampJPanel(userProcessContainer, userAccount,
                organization, enterprise, network);
        userProcessContainer.add("CampJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnCampsActionPerformed

    private void btnVacanciesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVacanciesActionPerformed
        // TODO add your handling code here:
        comboLiteracy.setVisible(false);
        
        PrincipalCreateVacanciesJPanel panel = new PrincipalCreateVacanciesJPanel(userProcessContainer, userAccount,
                organization, enterprise, network);
        userProcessContainer.add("PrincipalCreateVacanciesJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnVacanciesActionPerformed

    private void btnFundsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFundsActionPerformed
        // TODO add your handling code here:
        comboLiteracy.setVisible(false);
        
        RequestFundsJPanel panel = new RequestFundsJPanel(userProcessContainer, userAccount,
                organization, enterprise, network);
        userProcessContainer.add("RequestFundsJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        //
        
    }//GEN-LAST:event_btnFundsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCamps;
    private javax.swing.JButton btnFunds;
    private javax.swing.JButton btnLiteracy;
    private javax.swing.JButton btnRegistration;
    private javax.swing.JButton btnSurvey;
    private javax.swing.JButton btnVacancies;
    private javax.swing.JComboBox<String> comboLiteracy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblNetwork1;
    private javax.swing.JLabel lblNetwork2;
    private javax.swing.JLabel lblNetwork3;
    // End of variables declaration//GEN-END:variables
}
