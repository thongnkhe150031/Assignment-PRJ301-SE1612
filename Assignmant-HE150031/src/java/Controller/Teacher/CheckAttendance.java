/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Teacher;

import Controller.Authentication.BaseAuthen;
import DAL.AttendanceDB;
import Model.Attendance;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class CheckAttendance extends BaseAuthen {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int scheID = Integer.parseInt(request.getParameter("scheID"));
        Date date = Date.valueOf(request.getParameter("day"));
        int slotID = Integer.parseInt(request.getParameter("slotID"));
        AttendanceDB acDB = new AttendanceDB();
        ArrayList<Attendance> atten = acDB.getAttenBySDS(scheID, date, slotID);
        request.setAttribute("listAtten", atten);
        request.getRequestDispatcher("view/teacher/CheckAttendance.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int scheID = Integer.parseInt(request.getParameter("scheID"));
        Date date = Date.valueOf(request.getParameter("day"));
        int slotID = Integer.parseInt(request.getParameter("slotID"));
        AttendanceDB acDB = new AttendanceDB();
        ArrayList<Attendance> atten = acDB.getAttenBySDS(scheID, date, slotID);
        for (Attendance attendance : atten) {
            attendance.setAtten(Boolean.valueOf(request.getParameter("present"+attendance.getUserID())));
            attendance.setNote(request.getParameter("note"+attendance.getUserID()));
        }
        acDB.CheckAtten(atten);
        response.sendRedirect("ViewScheduleForAtten");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
