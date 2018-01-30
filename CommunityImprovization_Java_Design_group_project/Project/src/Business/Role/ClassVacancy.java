/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

/**
 *
 * @author mahes
 */
public class ClassVacancy {

    private String classNumber;
    private int TutionFee;
    private int vacancies;

    public int getTutionFee() {
        return TutionFee;
    }

    public void setTutionFee(int TutionFee) {
        this.TutionFee = TutionFee;
    }
   

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public int getVacancies() {
        return vacancies;
    }

    public void setVacancies(int vacancies) {
        this.vacancies = vacancies;
    }
    
    public ClassVacancy() {
    }
    
    public void decrementVacancies(){
        vacancies--;
    }
   
}
