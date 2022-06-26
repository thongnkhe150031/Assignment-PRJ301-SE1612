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
import Model.Account;
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
public class UpdateInforUser extends BaseAuthen {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int uid = Integer.parseInt(request.getParameter("uid"));
        MajorsDB ma = new MajorsDB();
        ArrayList<Majors> listMajorsAD = ma.getMajors();
        AccountDB acDB = new AccountDB();
        Account ac = acDB.getUserbyID(uid);
        RoleDB roleDB = new RoleDB();
        ArrayList<Role> listRole = roleDB.getRole();
        request.setAttribute("listRole", listRole);
        request.setAttribute("listMajorsAD", listMajorsAD);
        request.setAttribute("accAD", ac);
        request.getRequestDispatcher("view/admin/UpdateInforUser.jsp").forward(request, response);

    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userID = String.valueOf(request.getParameter("useID"));
        int uid = Integer.parseInt(userID);
        String fname = request.getParameter("fname");
        String pass = request.getParameter("pass");
        String phoneNumber = request.getParameter("phone");
        Date dob = Date.valueOf(request.getParameter("dob"));
        String address = request.getParameter("address");
        int major = Integer.parseInt(request.getParameter("majors"));
        int role = Integer.parseInt(request.getParameter("roles"));
        response.getWriter().print(uid);
        AccountDB acDB = new AccountDB();
        acDB.updateUserAD(fname, pass, phoneNumber, dob, address, major, role, uid);
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
