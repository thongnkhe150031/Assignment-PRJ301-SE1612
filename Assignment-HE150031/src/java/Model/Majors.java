/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public class Majors {
    private int majorsID;
    private String majorsName;

    public Majors() {
    }

    public Majors(int majorsID, String majorsName) {
        this.majorsID = majorsID;
        this.majorsName = majorsName;
    }

    public int getMajorsID() {
        return majorsID;
    }

    public void setMajorsID(int majorsID) {
        this.majorsID = majorsID;
    }

    public String getMajorsName() {
        return majorsName;  
    }

    public void setMajorsName(String majorsName) {
        this.majorsName = majorsName;
    }
    
}
