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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class login extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/auth/login.jsp").forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("email");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        AccountDB db = new AccountDB();
        Account account = db.getAccount(username, password);
        if (account != null) {
            HttpSession session = request.getSession();
            session.setAttribute("account", account);
            if (remember != null) {
                Cookie cuser = new Cookie("username", username);
                Cookie cpass = new Cookie("password", password);
                cuser.setMaxAge(3600);
                cpass.setMaxAge(3600);
                response.addCookie(cuser);
                response.addCookie(cpass);
            }
            if(account.getRole().getRoleID() == 2){
            response.sendRedirect("HomepageTeacher");
            }else if(account.getRole().getRoleID() == 1){
            response.sendRedirect("HomepageStudent");
            }else{
            response.sendRedirect("HomepageAdmin");
            }
        } else {
            response.sendRedirect("login");
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
