/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequest;

import Business.Network.Area;

/**
 *
 * @author pruth
 */
public class PoliceToPatrolWorkRequest extends WorkRequest{
    private static int requestID=1; 
    private Area area;
    private int vansRequested;
    private int counter;
    private String requestStatus;
    
    public PoliceToPatrolWorkRequest(){
        counter++;
        requestID=counter;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public int getVansRequested() {
        return vansRequested;
    }

    public void setVansRequested(int vansRequested) {
        this.vansRequested = vansRequested;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }
        
}
