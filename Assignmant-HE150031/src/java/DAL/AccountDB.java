/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Model.Account;
import Model.Majors;
import Model.Role;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class AccountDB extends DBContext {

    public Account getAccount(String email, String password) {
        try {
            String sql = "SELECT [UserID],[email],[password],[name],[dob],[gender],[phone],[address], b.[majorsID],b.MajorsName ,c.[roleID], c.roleName\n"
                    + "  FROM [User] a\n"
                    + "  inner join Majors b on a.majorsID = b.MajorsID\n"
                    + "  inner join [Role] c on  a.roleID = c.roleID \n"
                    + "  where [email] = ? and [password] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
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
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
