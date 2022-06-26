/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Controller.Authentication.BaseAuthen;
import DAL.AccountDB;
import DAL.RoleDB;
import Model.Account;
import Model.Role;
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
public class ViewUser extends BaseAuthen {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RoleDB roleDB = new RoleDB();
        AccountDB acDB = new AccountDB();
        ArrayList<Role> listRole = roleDB.getRole();
        ArrayList<Account> listAc = acDB.getStudentOrTeacher(listRole.get(0).getRoleID());
        request.setAttribute("listRole", listRole);
        request.setAttribute("listUser", listAc);
        request.getRequestDispatcher("view/admin/ViewUser.jsp").forward(request, response);
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
        int roleID = Integer.parseInt(request.getParameter("roleID"));
        RoleDB roleDB = new RoleDB();
        AccountDB acDB = new AccountDB();
        ArrayList<Role> listRole = roleDB.getRole();
        ArrayList<Account> listAc = acDB.getStudentOrTeacher(roleID);
        request.setAttribute("listRole", listRole);
        request.setAttribute("listUser", listAc);
        request.getRequestDispatcher("view/admin/ViewUser.jsp").forward(request, response);
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
