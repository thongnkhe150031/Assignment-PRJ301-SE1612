/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Teacher;

import Controller.Authentication.BaseAuthen;
import DAL.AttendanceDB;
import DAL.ClassDB;
import DAL.ScheduleDB;
import Model.Account;
import Model.Classs;
import Model.Schedule;
import Model.Timetable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class ViewScheduleForAtten extends BaseAuthen {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ScheduleDB scheDB = new ScheduleDB();
        Account account = (Account) request.getSession().getAttribute("account");
        ArrayList<Schedule> listScheByTeacher = scheDB.getScheduleByTeacher(account.getUserID());
        AttendanceDB attenDB = new AttendanceDB();
        ArrayList<Timetable> timetable = attenDB.getTimeTablebyClass(account.getUserID(), listScheByTeacher.get(0).getClss().getClassID());
        ClassDB clDB = new ClassDB();
        Classs clss = clDB.getClassbyClassID(listScheByTeacher.get(0).getClss().getClassID());
        request.setAttribute("classsID", clss);
        request.setAttribute("listScheByTeacher", listScheByTeacher);
        request.setAttribute("timetableByTeacher", timetable);
        request.getRequestDispatcher("view/teacher/ScheduleforAttendance.jsp").forward(request, response);

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
        ScheduleDB scheDB = new ScheduleDB();
        Account account = (Account) request.getSession().getAttribute("account");
        ArrayList<Schedule> listScheByTeacher = scheDB.getScheduleByTeacher(account.getUserID());
        int classID = Integer.parseInt(request.getParameter("ClassID"));
        AttendanceDB attenDB = new AttendanceDB();
        ArrayList<Timetable> timetable = attenDB.getTimeTablebyClass(account.getUserID(), classID);
        ClassDB clDB = new ClassDB();
        Classs clss = clDB.getClassbyClassID(classID);
        request.setAttribute("classsID", clss);
        request.setAttribute("listScheByTeacher", listScheByTeacher);
        request.setAttribute("timetableByTeacher", timetable);
        request.getRequestDispatcher("view/teacher/ScheduleforAttendance.jsp").forward(request, response);
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
