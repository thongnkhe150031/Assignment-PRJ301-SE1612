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
import Model.Subject;
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
public class ScheduleDB extends DBContext {

    public ArrayList<Schedule> getScheduleByTeacher(int userID) {
        ArrayList<Schedule> Sche = new ArrayList<>();
        try {
            String sql = "Select ScheID,  [Schedule].UserID, [User].name, [User].email, [User].password, [User].dob,[User].gender, [User].phone, [User].address, \n"
                    + "[User].majorsID, Majors.MajorsName , [User].roleID, [Role].roleName, Schedule.ClassID, Class.ClassName, [Subject].SubID, [Subject].SubCode,[Subject].Subname, \n"
                    + "[Subject].numberSlot, Schedule.StartDate, Schedule.EndDate\n"
                    + "from Schedule \n"
                    + "left join [User] on Schedule.UserID = [User].UserID\n"
                    + "left join Majors on [User].majorsID = [Majors].MajorsID\n"
                    + "left join [Role] on [User].roleID = [Role].roleID\n"
                    + "left join [Subject] on Schedule.SubID = [Subject].SubID\n"
                    + "left join [Class] on Schedule.ClassID = [Class].ClassID where Schedule.UserID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Schedule sch = new Schedule();
                sch.setScheID(rs.getInt("ScheID"));
                sch.setSdate(rs.getDate("StartDate"));
                sch.setEdate(rs.getDate("EndDate"));
                Account ac = new Account();
                ac.setUserID(rs.getInt("UserID"));
                ac.setEmail(rs.getString("email"));
                ac.setPassword(rs.getString("password"));
                ac.setName(rs.getString("name"));
                ac.setGender(rs.getBoolean("gender"));
                ac.setDob(rs.getDate("dob"));
                ac.setAddress(rs.getString("address"));
                ac.setPhone(rs.getString("phone"));
                Role role = new Role();
                role.setRoleID(rs.getInt("roleID"));
                role.setRoleName(rs.getString("roleName"));
                Majors maj = new Majors();
                maj.setMajorsID(rs.getInt("majorsId"));
                maj.setMajorsName(rs.getString("MajorsName"));
                ac.setMajor(maj);
                ac.setRole(role);
                Subject sbj = new Subject();
                sbj.setSubID(rs.getInt("SubID"));
                sbj.setSubCode(rs.getString("SubCode"));
                sbj.setSubName(rs.getString("SubName"));
                sbj.setNumberSlot(rs.getInt("numberSlot"));
                Classs cls = new Classs();
                cls.setClassID(rs.getInt("ClassID"));
                cls.setClassName(rs.getString("ClassName"));
                sch.setUser(ac);
                sch.setSub(sbj);
                sch.setClss(cls);
                Sche.add(sch);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Sche;
    }
}
