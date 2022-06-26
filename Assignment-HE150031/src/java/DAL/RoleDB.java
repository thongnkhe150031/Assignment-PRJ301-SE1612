/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Model.Role;
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
public class RoleDB extends DBContext {

    public ArrayList<Role> getRole() {
        ArrayList<Role> role = new ArrayList<>();
        try {
            String sql = "Select * from [Role] where roleID != 3";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
            Role rl = new Role();
            rl.setRoleID(rs.getInt("roleID"));
            rl.setRoleName(rs.getString("roleName"));
            role.add(rl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return role;
    }
    
    public static void main(String[] args) {
        RoleDB roDB = new RoleDB();
        System.out.println(roDB.getRole().size());
    }
}
