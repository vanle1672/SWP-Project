/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control;

import DAO.LoginDAO;
import DAO.SendEmail;
import Model.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author ASUS
 */
public class forgotPass extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Account acc =(Account) session.getAttribute("acc");
        
        String email = request.getParameter("email");
        if(email == ""){
            request.setAttribute("mess0", "Vui lòng nhập email!");
            request.getRequestDispatcher("Quenmatkhau.jsp").forward(request, response);
        }
        LoginDAO DAO = new LoginDAO();
        Account a = DAO.checkAccountExist(email);
        if(a ==null){
              request.setAttribute("mess1", "Email sai hoặc không tồn tại!");
            request.getRequestDispatcher("Quenmatkhau.jsp").forward(request, response);
        } else {
            SendEmail send = new SendEmail();
            String otp = send.getRandom();
            
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
