package Control.Admin;

import Dao.AppointmentDao;
import Model.Appointment;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

public class ViewPatientAppointment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("user_id"));
        ArrayList<Appointment> appointments = new ArrayList<>();
        AppointmentDao appointmentDao = new AppointmentDao();
        appointments = appointmentDao.getAllAppointmentsOfPatient(id);
        req.setAttribute("appointments", appointments);
        req.getRequestDispatcher("/WEB-INF/views/admin/view-appointments-of-patient.jsp").forward(req, resp);
    }
}
