/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequest;

/**
 *
 * @author aravind
 */
public class DoctorToCitizenWorkreq extends WorkRequest{
    
    private String treatment;
    private String funds;
    private int patientid;
    private String disease;
    private String patientName;
    private String fundsGranted;
    private VolunteerToDoctor volunteerToDoctorWorkRequest;

    public VolunteerToDoctor getVolunteerToDoctorWorkRequest() {
        return volunteerToDoctorWorkRequest;
    }

    public void setVolunteerToDoctorWorkRequest(VolunteerToDoctor volunteerToDoctorWorkRequest) {
        this.volunteerToDoctorWorkRequest = volunteerToDoctorWorkRequest;
    }

    public DoctorToCitizenWorkreq(String treatment) {
        this.treatment=treatment;
        
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getFunds() {
        return funds;
    }

    public void setFunds(String funds) {
        this.funds = funds;
    }

    public int getPatientid() {
        return patientid;
    }
    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getFundsGranted() {
        return fundsGranted;
    }

    public void setFundsGranted(String fundsGranted) {
        this.fundsGranted = fundsGranted;
    }
    
}
