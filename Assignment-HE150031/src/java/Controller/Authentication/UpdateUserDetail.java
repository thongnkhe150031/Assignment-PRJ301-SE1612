/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Authentication;

import DAL.AccountDB;
import DAL.MajorsDB;
import Model.Account;
import Model.Majors;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class UpdateUserDetail extends BaseAuthen {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MajorsDB ma = new MajorsDB();
        ArrayList<Majors> listMajors = ma.getMajors();
        request.setAttribute("listMajors", listMajors);
        request.getRequestDispatcher("view/auth/UpdateUser.jsp").forward(request, response);
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
        try {
            Account account = (Account) request.getSession().getAttribute("account");
            String fname = request.getParameter("fname");
            String phoneNumber = request.getParameter("phone");
            Date dob = Date.valueOf(request.getParameter("dob"));
            String address = request.getParameter("address");
            int major = Integer.parseInt(request.getParameter("major"));
            String patter = "[0-9]+";
            if (!phoneNumber.matches(patter)) {
                response.sendRedirect("UpdateUser");
            } else {
                AccountDB acDB = new AccountDB();
                acDB.updateUser(fname, phoneNumber, dob, address, account.getUserID(), major);
                response.sendRedirect("UserDetail");
            }
        } catch (Exception e) {
            response.sendRedirect("UpdateUser");
        }
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
