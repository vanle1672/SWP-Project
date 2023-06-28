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


@WebServlet(name = "LoadPatients", urlPatterns = {"/LoadPatients"})
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
        System.out.println("gender line 36 loadpatient : "+list.get(0).gender);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/WEB-INF/views/admin/patient-control.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String verify_key = UUID.randomUUID().toString();
        AuthDao dao = new AuthDao();
        try {
            dao.createPatients(name,email,password,phone,verify_key,true);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("LoadPatients");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>



}
