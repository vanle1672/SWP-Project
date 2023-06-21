package Control;

import Model.Doctor;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DoctorProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Doctor doctor = (Doctor)req.getAttribute("doctor");
        req.setAttribute("doctor", doctor);
        req.getRequestDispatcher("/WEB-INF/views/doctor/profile.jsp").forward(req,resp);
    }
}
