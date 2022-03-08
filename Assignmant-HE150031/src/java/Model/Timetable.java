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
public class Timetable {
    private int Sche;
    private String subCode;
    private Date date;
    private Slot slot;
    public Timetable() {
    }

    public Timetable(int Sche, String subCode, Date date, Slot slot) {
        this.Sche = Sche;
        this.subCode = subCode;
        this.date = date;
        this.slot = slot;
    }

    public int getSche() {
        return Sche;
    }

    public void setSche(int Sche) {
        this.Sche = Sche;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
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


}
