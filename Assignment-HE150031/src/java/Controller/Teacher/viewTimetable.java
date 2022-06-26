/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Teacher;

import Controller.Authentication.BaseAuthen;
import DAL.AttendanceDB;
import DAL.ClassDB;
import Model.Account;
import Model.Classs;
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
public class viewTimetable extends BaseAuthen {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int classid = Integer.parseInt(request.getParameter("ClassID"));
        ClassDB clDB = new ClassDB();
        Classs classs = clDB.getClassbyClassID(Integer.parseInt(request.getParameter("ClassID")));
        Account account = (Account) request.getSession().getAttribute("account");
        AttendanceDB attenDB = new AttendanceDB();
        ArrayList<Timetable> timetable = attenDB.getTimeTablebyClass(account.getUserID(), classid);
        request.setAttribute("timetableByTeacher", timetable);
        request.setAttribute("classs", classs);
//        response.getWriter().print(classs.getClassName());
        request.getRequestDispatcher("view/teacher/TimetableClass.jsp").forward(request, response);
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
        int classid = Integer.parseInt(request.getParameter("ClassID"));
        ClassDB clDB = new ClassDB();
        Classs classs = clDB.getClassbyClassID(Integer.parseInt(request.getParameter("ClassID")));
        Account account = (Account) request.getSession().getAttribute("account");
        int userID = account.getUserID();
        AttendanceDB attenDB = new AttendanceDB();
        ArrayList<Timetable> timetable = attenDB.getTimeTablebyClass(userID, classid);
        request.setAttribute("timetableByTeacher", timetable);
        request.setAttribute("classs", classs);
        request.getRequestDispatcher("view/teacher/TimetableClass.jsp").forward(request, response);
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
