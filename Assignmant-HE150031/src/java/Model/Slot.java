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
public class Slot {
    private int SlotID;
    private String SlotTime;

    public Slot() {
    }

    public Slot(int SlotID, String SlotTime) {
        this.SlotID = SlotID;
        this.SlotTime = SlotTime;
    }

    public int getSlotID() {
        return SlotID;
    }

    public void setSlotID(int SlotID) {
        this.SlotID = SlotID;
    }

    public String getSlotTime() {
        return SlotTime;
    }

    public void setSlotTime(String SlotTime) {
        this.SlotTime = SlotTime;
    }
    
    
}
