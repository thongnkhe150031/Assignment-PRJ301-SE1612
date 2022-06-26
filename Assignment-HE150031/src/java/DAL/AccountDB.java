/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Model.Account;
import Model.Majors;
import Model.Role;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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

    public void updateUser(String name, String phone, Date dob, String address, int UserID, int major) {
        try {
            String sql = "UPDATE [dbo].[User]\n"
                    + "   SET [name] = ?\n"
                    + "      ,[dob] = ?\n"
                    + "      ,[phone] = ? \n"
                    + "      ,[address] =? \n"
                    + "      ,[majorsID] = ?\n"
                    + " WHERE [UserID] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setDate(2, dob);
            statement.setString(3, phone);
            statement.setString(4, address);
            statement.setInt(5, major);
            statement.setInt(6, UserID);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Account getUserbyID(int id) {
        try {
            String sql = "SELECT [UserID],[email],[password],[name],[dob],[gender],[phone],[address], b.[majorsID],b.MajorsName ,c.[roleID], c.roleName\n"
                    + "  FROM [User] a\n"
                    + "  inner join Majors b on a.majorsID = b.MajorsID\n"
                    + "  inner join [Role] c on  a.roleID = c.roleID \n"
                    + "  where [UserID] = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
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

    public ArrayList<Account> getStudentOrTeacher(int majorid) {
        ArrayList<Account> ac = new ArrayList<>();
        try {
            String sql = "SELECT [UserID],[email],[password],[name],[dob],[gender],[phone],[address], b.[majorsID],b.MajorsName ,c.[roleID], c.roleName\n"
                    + "FROM [User] a inner join Majors b on a.majorsID = b.MajorsID\n"
                    + " inner join [Role] c on  a.roleID = c.roleID\n"
                    + "where a.roleID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, majorid);
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
                ac.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ac;
    }

    public void deleteUser(int id) {
        try {
            String sql = "DELETE FROM [dbo].[User]\n"
                    + "      WHERE UserID = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertUser(String email, String name, Date dob, Boolean gender, String phone, String address, int major, int role) {
        try {
            String sql = "INSERT INTO [dbo].[User]\n"
                    + "           ([email]\n"
                    + "           ,[password]\n"
                    + "           ,[name]\n"
                    + "           ,[dob]\n"
                    + "           ,[gender]\n"
                    + "           ,[phone]\n"
                    + "           ,[address]\n"
                    + "           ,[majorsID]\n"
                    + "           ,[roleID])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, "1");
            stm.setString(3, name);
            stm.setDate(4, dob);
            stm.setBoolean(5, gender);
            stm.setString(6, phone);
            stm.setString(7, address);
            stm.setInt(8, major);
            stm.setInt(9, role);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updatePassUser(String pass, int userID) {
        try {
            String sql = "UPDATE [dbo].[User]\n"
                    + "   SET [password] = ?\n"
                    + " WHERE [UserID] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pass);
            statement.setInt(2, userID);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateUserAD(String name, String pass, String phone, Date dob, String address, int UserID, int major, int role) {
        try {
            String sql = "UPDATE [dbo].[User]\n"
                    + "   SET [name] = ?\n"
                    + "      ,[password] = ?\n"
                    + "      ,[dob] = ?\n"
                    + "      ,[phone] = ? \n"
                    + "      ,[address] =? \n"
                    + "      ,[majorsID] = ?\n"
                    + "      ,[roleID] = ?\n"
                    + " WHERE [UserID] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, pass);
            statement.setDate(3, dob);
            statement.setString(4, phone);
            statement.setString(5, address);
            statement.setInt(6, major);
            statement.setInt(7, role);
            statement.setInt(8, UserID);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        AccountDB ac = new AccountDB();
        String a = "1";
        int i = Integer.parseInt(a);
        System.out.println(i);
//        ac.updateUser("Nguyen Kiem Thong", "0886969888", Date.valueOf("2001-08-08"), "Hung Yen", 1, 1);
//     ac.insertUser("gogo@fpt.vn", "thong", Date.valueOf("2001-01-01"), true, "012345", "Ha Noi", 1, 1);
//          ac.deleteUser(17);
// 
    }
}
