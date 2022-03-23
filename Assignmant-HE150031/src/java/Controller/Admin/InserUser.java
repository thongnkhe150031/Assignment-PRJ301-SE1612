/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Controller.Authentication.BaseAuthen;
import DAL.AccountDB;
import DAL.MajorsDB;
import DAL.RoleDB;
import Model.Majors;
import Model.Role;
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
public class InserUser extends BaseAuthen {

    
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MajorsDB majorDB = new MajorsDB();
        RoleDB roleDB = new RoleDB();
        ArrayList<Majors> maj = majorDB.getMajors();
        ArrayList<Role> rol = roleDB.getRole();
        request.setAttribute("listMajor1", maj);
        request.setAttribute("listRole1", rol);
        request.getRequestDispatcher("view/admin/InsertUser.jsp").forward(request, response);
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
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        Date date = Date.valueOf(request.getParameter("dob"));
        boolean gender = Boolean.valueOf(request.getParameter("gender"));
        int majorID = Integer.parseInt(request.getParameter("major"));
        int roleID = Integer.parseInt(request.getParameter("role"));
        response.getWriter().println(name);
        response.getWriter().println(email);
        response.getWriter().println(phone);
        response.getWriter().println(address);
        response.getWriter().println(date);
        response.getWriter().println(gender);
        response.getWriter().println(majorID);
        response.getWriter().println(roleID);
        AccountDB acDB = new AccountDB();
        acDB.insertUser(email, name, date, gender, phone, address, majorID, roleID);
        response.sendRedirect("ViewUser");
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
