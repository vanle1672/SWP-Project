/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control;

import DAO.LoginDAO;

import Model.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import static org.apache.coyote.http11.Constants.a;

/**
 *
 * @author ASUS
 */
public class signup extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");
            String name = request.getParameter("name");
            String confirmpass = request.getParameter("confirm");
            String phone = request.getParameter("phone");

        
            String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,16}$";
            if (!pass.matches(passwordRegex)) {
                request.setAttribute("mess0", "Mật khẩu phải có 8-16 kí tự, bao gồm ít nhất một chữ hoa, một chữ thường và một số!");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            } else if (!pass.equals(confirmpass)) {
                request.setAttribute("mess1", "Mật khẩu không trùng khớp!");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            } else {
                LoginDAO DAO = new LoginDAO();
                Account a = DAO.checkAccountExist(email);
                if (a == null) {
                    DAO.signup(email, pass, name, phone);
                    request.setAttribute("mess2", "Tạo tài khoản thành công!");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                } else {
                    request.setAttribute("mess3", "Email đã tồn tại!");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
           
        }
    }

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
