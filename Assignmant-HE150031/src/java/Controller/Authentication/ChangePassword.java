/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Authentication;

import DAL.AccountDB;
import Model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class ChangePassword extends BaseAuthen {

    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/auth/changePass.jsp").forward(request, response);
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
        String email = request.getParameter("email");
        String opass = request.getParameter("opass");
        AccountDB acDB = new AccountDB();
        Account ac = acDB.getAccount(email, opass);
        if (ac == null) {
            request.setAttribute("mess", "Incorrect password.");
            request.getRequestDispatcher("view/auth/changePass.jsp").forward(request, response);
        }
        String npass = request.getParameter("npass");
        String cpass = request.getParameter("cpass");
        if (!npass.equals(cpass)) {
            request.setAttribute("mess", "The re-entered password does not match the new password.");
            request.getRequestDispatcher("view/auth/changePass.jsp").forward(request, response);
        }
        acDB.updatePassUser(cpass, ac.getUserID());
        request.setAttribute("mess", "Change password successfully.");
        request.getRequestDispatcher("view/auth/changePass.jsp").forward(request, response);
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
