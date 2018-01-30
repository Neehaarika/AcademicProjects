/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequest;

/**
 *
 * @author mahes
 */
public class EducationFunds extends WorkRequest{
    private String reqFunds;
    private String collectedFunds;

    public String getReqFunds() {
        return reqFunds;
    }

    public void setReqFunds(String reqFunds) {
        this.reqFunds = reqFunds;
    }

    public String getCollectedFunds() {
        return collectedFunds;
    }

    public void setCollectedFunds(String collectedFunds) {
        this.collectedFunds = collectedFunds;
    }

    
    
    @Override
    public String toString() {
        return this.reqFunds; //To change body of generated methods, choose Tools | Templates.
    }
   
}
