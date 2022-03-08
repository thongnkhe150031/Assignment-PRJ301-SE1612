/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Model.Account;
import Model.Classs;
import Model.Majors;
import Model.Role;
import Model.Schedule;
import Model.Slot;
import Model.Subject;
import Model.Timetable;
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
}
