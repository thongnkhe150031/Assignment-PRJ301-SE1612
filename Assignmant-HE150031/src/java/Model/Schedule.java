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
public class Schedule {
    private int scheID;
    private Account user;
    private Subject sub;
    private Classs clss;
    private Date Sdate;
    private Date Edate;

    public Schedule() {
    }

    public Schedule(int scheID, Account user, Subject sub, Classs clss, Date Sdate, Date Edate) {
        this.scheID = scheID;
        this.user = user;
        this.sub = sub;
        this.clss = clss;
        this.Sdate = Sdate;
        this.Edate = Edate;
    }

    public int getScheID() {
        return scheID;
    }

    public void setScheID(int scheID) {
        this.scheID = scheID;
    }

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }

    public Subject getSub() {
        return sub;
    }

    public void setSub(Subject sub) {
        this.sub = sub;
    }

    public Classs getClss() {
        return clss;
    }

    public void setClss(Classs clss) {
        this.clss = clss;
    }

    public Date getSdate() {
        return Sdate;
    }

    public void setSdate(Date Sdate) {
        this.Sdate = Sdate;
    }

    public Date getEdate() {
        return Edate;
    }

    public void setEdate(Date Edate) {
        this.Edate = Edate;
    }
    
    
    
}
