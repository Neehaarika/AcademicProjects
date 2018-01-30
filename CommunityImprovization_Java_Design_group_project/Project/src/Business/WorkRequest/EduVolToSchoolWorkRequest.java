/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequest;

import Business.Network.Area;

/**
 *
 * @author mahes
 */
public class EduVolToSchoolWorkRequest extends WorkRequest {
    private static int counter=0; 
    
    private Area area;
    private int surveyID;
    private String personName;
    private String age;
    private String eduStatus;
    private String eduHighest;
    private boolean literate;

    public boolean isLiterate() {
        return literate;
    }

    public void setLiterate(boolean literate) {
        this.literate = literate;
    }

     public EduVolToSchoolWorkRequest(){
        counter++;
        surveyID=counter;
    }
    
    
    
    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        EduVolToSchoolWorkRequest.counter = counter;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public int getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(int surveyID) {
        this.surveyID = surveyID;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEduStatus() {
        return eduStatus;
    }

    public void setEduStatus(String eduStatus) {
        this.eduStatus = eduStatus;
    }

    public String getEduHighest() {
        return eduHighest;
    }

    public void setEduHighest(String eduHighest) {
        this.eduHighest = eduHighest;
    }
    

    @Override
    public String toString() {
        return this.personName; //To change body of generated methods, choose Tools | Templates.
    }
   
}
