/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

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
public class SubjectDB extends DBContext {

    public ArrayList<Subject> getAllSubject() {
        ArrayList<Subject> listSub = new ArrayList<>();
        try {
            String sql = "select * from Subject";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Subject sub = new Subject();
                sub.setSubID(rs.getInt("SubID"));
                sub.setSubName(rs.getString("Subname"));
                sub.setSubCode(rs.getString("SubCode"));
                sub.setNumberSlot(rs.getInt("numberSlot"));
                listSub.add(sub);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSub;
    }

    public Subject getSubjectbyID(int SubID) {
        try {
            String sql = "select * from Subject where SubID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
           if (rs.next()) {
                Subject sub = new Subject();
                sub.setSubID(rs.getInt("SubID"));
                sub.setSubName(rs.getString("Subname"));
                sub.setSubCode(rs.getString("SubCode"));
                sub.setNumberSlot(rs.getInt("numberSlot"));
                return sub;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
