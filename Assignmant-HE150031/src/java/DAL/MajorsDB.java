/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Model.Majors;
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
public class MajorsDB extends DBContext {

    public ArrayList<Majors> getMajors() {
        ArrayList<Majors> listMajor = new ArrayList<>();
        try {
            String sql = "Select MajorsID, MajorsName from Majors where MajorsID !=0";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Majors ma = new Majors();
                ma.setMajorsID(rs.getInt("MajorsID"));
                ma.setMajorsName(rs.getString("MajorsName"));
                listMajor.add(ma);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMajor;
    }

    public static void main(String[] args) {
        MajorsDB ma = new MajorsDB();
        ArrayList<Majors> listMajor = ma.getMajors();
        System.out.println(listMajor.size());
    }
}
