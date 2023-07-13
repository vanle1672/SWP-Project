package Control.Admin;

import Dao.PatientDao;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UpdatePatient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("pid"));
        User user = new PatientDao().getPatientById(id);
        System.out.println(user.toString());
        req.setAttribute("patient", user);
        req.getRequestDispatcher("/WEB-INF/views/admin/update-patient.jsp").forward(req, resp);
    }
}
