/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Model.Account;
import Model.Attendance;
import Model.Classs;
import Model.Majors;
import Model.Role;
import Model.Schedule;
import Model.Slot;
import Model.Subject;
import Model.Timetable;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class AttendanceDB extends DBContext {

    public ArrayList<Timetable> getTimeTablebyClass(int userID, int clssID) {
        ArrayList<Timetable> timetable = new ArrayList<>();
        try {
            String sql = "Select distinct Attendance.ScheID, [Subject].SubCode, [Date], Attendance.SlotID, Slot.[Time]\n"
                    + "from Attendance left join Schedule \n"
                    + "on Attendance.ScheID = Schedule.ScheID\n"
                    + "left join [Subject] on Schedule.SubID = [Subject].SubID\n"
                    + "left join Slot on Attendance.SlotID = Slot.SlotID\n"
                    + "where Schedule.UserID = ? and Schedule.ClassID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userID);
            stm.setInt(2, clssID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Timetable ttable = new Timetable();
                ttable.setSche(rs.getInt("ScheID"));
                ttable.setSubCode(rs.getString("SubCode"));
                ttable.setDate(rs.getDate("Date"));
                Slot sl = new Slot();
                sl.setSlotID(rs.getInt("SlotID"));
                sl.setSlotTime(rs.getString("Time"));
                ttable.setSlot(sl);
                timetable.add(ttable);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return timetable;
    }

    public ArrayList<Attendance> getScheduleByStudent(int userID) {
        ArrayList<Attendance> atten = new ArrayList<>();
        try {
            String sql = "Select AttenID, Attendance.UserID as studentID ,Attendance.ScheID, Schedule.UserID, [User].email, [User].[password], [User].[name], [User].dob,\n"
                    + "[User].gender, [User].[address], [User].phone, [User].majorsID, Majors.MajorsName, [User].roleID,\n"
                    + "[Role].roleName, Schedule.ClassID, Class.ClassName, [Subject].SubID, [Subject].SubCode,[Subject].Subname, \n"
                    + "[Subject].numberSlot, Schedule.StartDate, Schedule.EndDate,[Date], Attendance.SlotID, Slot.[Time],Attendance, note from Attendance\n"
                    + "left join Schedule on Attendance.ScheID = Schedule.ScheID\n"
                    + "left join [User] on Schedule.UserID = [User].UserID \n"
                    + "left join [Majors] on [User].majorsID = [Majors].MajorsID\n"
                    + "left join [Role] on  [User].roleID = [Role].roleID\n"
                    + "left join [Subject] on [Schedule].SubID = [Subject].SubID\n"
                    + "left join [Class] on [Schedule].ClassID = [Class].ClassID\n"
                    + "left join [Slot] on [Attendance].SlotID = Slot.SlotID\n"
                    + "where Attendance.UserID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance at = new Attendance();
                at.setAttenID(rs.getInt("AttenID")); //1
                at.setUserID(rs.getInt("studentID"));  //2
                at.setAtten(rs.getBoolean("Attendance")); //3
                at.setNote(rs.getString("note")); //4
                at.setDate(rs.getDate("Date")); //5

                Schedule sche = new Schedule();
                sche.setScheID(rs.getInt("ScheID"));
                sche.setSdate(rs.getDate("StartDate"));
                sche.setEdate(rs.getDate("EndDate"));

                Subject sbj = new Subject();
                sbj.setSubID(rs.getInt("SubID"));
                sbj.setSubCode(rs.getString("SubCode"));
                sbj.setSubName(rs.getString("Subname"));
                sbj.setNumberSlot(rs.getInt("numberSlot"));

                Classs cls = new Classs();
                cls.setClassID(rs.getInt("ClassID"));
                cls.setClassName(rs.getString("ClassName"));

                Account user = new Account();
                user.setUserID(rs.getInt("UserID"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setDob(rs.getDate("dob"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));

                Majors ma = new Majors();
                ma.setMajorsID(rs.getInt("majorsID"));
                ma.setMajorsName(rs.getString("MajorsName"));

                Role role = new Role();
                role.setRoleID(rs.getInt("roleID"));
                role.setRoleName(rs.getString("roleName"));

                user.setMajor(ma);
                user.setRole(role);
                sche.setUser(user);
                sche.setClss(cls);
                sche.setSub(sbj);
                at.setSche(sche);

                Slot sl = new Slot();
                sl.setSlotID(rs.getInt("SlotID"));
                sl.setSlotTime(rs.getString("Time"));

                at.setSche(sche); //6
                at.setSlot(sl); //7
                atten.add(at);
            }
        } catch (Exception ex) {
            Logger.getLogger(AttendanceDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return atten;
    }

    public void insertSchedule(int classID, int scheID, Date date, int slot) {
        try {
            connection.setAutoCommit(false);
            ClassDB clDB = new ClassDB();
            ArrayList<Account> accounts = clDB.getUserInClass(classID);
            for (Account account : accounts) {
                String sql = "INSERT INTO [dbo].[Attendance]\n"
                        + "           ([UserID]\n"
                        + "           ,[ScheID]\n"
                        + "           ,[Date]\n"
                        + "           ,[SlotID]\n"
                        + "           ,[Attendance]\n"
                        + "           ,[note])\n"
                        + "     VALUES(?, ?, ?, ?, ?, ?)";
                PreparedStatement stm = connection.prepareStatement(sql);
                stm.setInt(1, account.getUserID());
                stm.setInt(2, scheID);
                stm.setDate(3, date);
                stm.setInt(4, slot);
                stm.setBoolean(5, false);
                stm.setString(6, null);
                stm.executeUpdate();
            }
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDB.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(AttendanceDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(AttendanceDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        AttendanceDB atenDB = new AttendanceDB();
        atenDB.insertSchedule(1, 1, Date.valueOf("2022-01-10"), 1);
    }
}
