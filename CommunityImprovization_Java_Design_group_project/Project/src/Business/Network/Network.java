/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;
import java.util.ArrayList;

/**
 *
 * @author mahes
 */
public class Network {

    private String name;
    private int networkID;
    private static int count;
    private EnterpriseDirectory enterpriseDirectory;
    private ArrayList<Area> areaList;

    public Network() {

        enterpriseDirectory = new EnterpriseDirectory();
        this.networkID = ++count;
        this.areaList = new ArrayList<Area>();
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNetworkID() {
        return networkID;
    }

    public ArrayList<Area> getAreaList() {
        return areaList;
    }

    @Override
    public String toString() {
        return name;
    }
    
     public Area createANewArea(String areaName){
        Area area = new Area(areaName);
        areaList.add(area);
        return area;
    }

}
