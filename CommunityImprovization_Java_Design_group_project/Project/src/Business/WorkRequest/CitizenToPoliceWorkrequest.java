/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequest;

import Business.Network.Area;
import Business.Network.Network;

/**
 *
 * @author pruth
 */
public class CitizenToPoliceWorkrequest extends WorkRequest{
    private static int count=1;
    private int incidentID;
    private String name;
    private Area area;
    private Network network;
    private String phn;
    private String incidentType;
    private int severityPoints;
    private String actionTaken;

    public CitizenToPoliceWorkrequest() {
        count++;
        incidentID=count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }   

    public String getPhn() {
        return phn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public void setIncidentTpe(String incidentType) {
        this.incidentType = incidentType;
    }

    public int getSeverityPoints() {
        return severityPoints;
    }

    public void setSeverityPoints(int severityPoints) {
        this.severityPoints = severityPoints;
    }

    public int getIncidentID() {
        return incidentID;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public String getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    
}
