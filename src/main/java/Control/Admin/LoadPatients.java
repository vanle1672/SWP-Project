package Control.Admin;

import Dao.Admin.UpdateUser;
import Dao.AuthDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.User;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoadPatients extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        UpdateUser dao = new UpdateUser();
        List<User> list = dao.getPatientsList();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/WEB-INF/views/admin/patient-control.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        boolean gender = true;
        if(request.getParameter("gender").equals("0")){
             gender = false;
        }
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String dob = request.getParameter("dob");
        String verify_key = UUID.randomUUID().toString();
        AuthDao dao = new AuthDao();
        try {
            dao.createPatients(name,email,password, phone, dob,gender,address,  verify_key);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoadPatients.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect(request.getContextPath() +"/admin/patients-control");
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>



}
