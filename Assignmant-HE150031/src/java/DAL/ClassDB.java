/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Class;
import Model.Majors;
import Model.Role;

/**
 *
 * @author Admin
 */
public class ClassDB extends DBContext {

    public ArrayList<Class> getClss() {
        ArrayList<Class> cls = new ArrayList<>();
        try {
            String sql = "SELECT ClassID, ClassName FROM Class";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Class c = new Class();
                c.setClassID(rs.getInt("ClassID"));
                c.setClassName(rs.getString("ClassName"));
                cls.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cls;
    }

    public ArrayList<Account> getUserInClass(int ClassID) {
        ArrayList<Account> member = new ArrayList<>();
        try {
            String sql = "Select Class.ClassName, [User].UserID, [User].name, [User].email, [User].password, [User].dob,[User].gender, [User].phone, [User].address, [User].majorsID, Majors.MajorsName , [User].roleID, [Role].roleName\n"
                    + "from Class \n"
                    + "left join ClassMember on Class.ClassID = ClassMember.ClassID\n"
                    + "left join [User] on ClassMember.UserID = [User].UserID \n"
                    + "left join Majors on [User].majorsID = [Majors].MajorsID\n"
                    + "left join [Role] on [User].roleID = [Role].roleID\n"
                    + "where Class.ClassID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, ClassID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setUserID(rs.getInt("UserID"));
                account.setEmail(rs.getString("email"));
                account.setPassword(rs.getString("password"));
                account.setName(rs.getString("name"));
                account.setDob(rs.getDate("dob"));
                account.setGender(rs.getBoolean("gender"));
                account.setPhone(rs.getString("phone"));
                account.setAddress(rs.getString("address"));
                Majors majors = new Majors();
                majors.setMajorsID(rs.getInt("majorsID"));
                majors.setMajorsName(rs.getString("MajorsName"));
                Role role = new Role();
                role.setRoleID(rs.getInt("roleID"));
                role.setRoleName(rs.getString("roleName"));
                account.setMajor(majors);
                account.setRole(role);
                member.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return member;
    }
}
