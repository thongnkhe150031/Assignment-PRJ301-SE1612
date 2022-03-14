/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Authentication;

import DAL.AccountDB;
import DAL.ClassDB;
import DAL.ScheduleDB;
import Model.Account;
import Model.Classs;
import Model.Schedule;
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
public class viewMemberInClass extends BaseAuthen{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("ClassID"));
        ClassDB clDB = new ClassDB();
        ArrayList<Account> userInClass = clDB.getUserInClass(id);
        ArrayList<Classs> getClass = clDB.getClss();
        request.setAttribute("getClass", getClass);
        request.setAttribute("classID", id);
        request.setAttribute("userInClass", userInClass);
        request.getRequestDispatcher("view/auth/memInClass.jsp").forward(request, response);
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
        int id = Integer.parseInt(request.getParameter("classid"));
        ClassDB clDB = new ClassDB();
        ArrayList<Account> userInClass = clDB.getUserInClass(id);
        ArrayList<Classs> getClass = clDB.getClss();
        request.setAttribute("getClass", getClass);
        request.setAttribute("classID", id);
        request.setAttribute("userInClass", userInClass);
        request.getRequestDispatcher("view/auth/memInClass.jsp").forward(request, response);
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
