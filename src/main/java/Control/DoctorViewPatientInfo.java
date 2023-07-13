package Control;

import Dao.PatientDao;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DoctorViewPatientInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("user_id"));
        PatientDao patientDao = new PatientDao();
        User user = patientDao.getPatientById(id);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/views/doctor/view-user-info.jsp").forward(req, resp);
    }
}
