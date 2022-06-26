/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Controller.Authentication.BaseAuthen;
import DAL.ClassDB;
import DAL.ScheduleDB;
import Model.Classs;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class InsertSchedule extends BaseAuthen{

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/admin/insertScheduleAD.jsp").forward(request, response);
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
        int tid = Integer.parseInt(request.getParameter("tid"));
        int sid = Integer.parseInt(request.getParameter("sid"));
        String cname = request.getParameter("cname");
        Date sdate = Date.valueOf(request.getParameter("sdate"));
        Date edate = Date.valueOf(request.getParameter("edate"));
        ClassDB clDB = new ClassDB();
        Classs clss = clDB.getClassbyName(cname);
        ScheduleDB scheDB = new ScheduleDB();
        scheDB.InsertScheduleAD(tid, sid, clss.getClassID(), sdate, edate);
        response.sendRedirect("ViewAllSchedule");
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
