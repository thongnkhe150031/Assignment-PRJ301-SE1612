/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Attendance {
    private int attenID;
    private Schedule Sche;
    private Account User;
    private Date date;
    private Slot slot;
    private boolean atten;
    private String note;

    public Attendance() {
    }

    public Attendance(int attenID, Schedule Sche, Account User, Date date, Slot slot, boolean atten, String note) {
        this.attenID = attenID;
        this.Sche = Sche;
        this.User = User;
        this.date = date;
        this.slot = slot;
        this.atten = atten;
        this.note = note;
    }

    public int getAttenID() {
        return attenID;
    }

    public void setAttenID(int attenID) {
        this.attenID = attenID;
    }

    public Schedule getSche() {
        return Sche;
    }

    public void setSche(Schedule Sche) {
        this.Sche = Sche;
    }

    public Account getUser() {
        return User;
    }

    public void setUser(Account User) {
        this.User = User;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public boolean isAtten() {
        return atten;
    }

    public void setAtten(boolean atten) {
        this.atten = atten;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
}
