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
public class AlertsWorkRequest extends WorkRequest{
    private Area area;
    private Network network;
    private String crimeType;
    private String alertStatus;

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

    public String getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }

    public String getAlertStatus() {
        return alertStatus;
    }

    public void setAlertStatus(String alertStatus) {
        this.alertStatus = alertStatus;
    }

    @Override
    public String toString() {
        return this.alertStatus; //To change body of generated methods, choose Tools | Templates.
    }
 
    
}
