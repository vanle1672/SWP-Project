package Control;

import Dao.AppointmentDao;
import Dao.DoctorDao;
import Model.Data;
import Model.Doctor;
import Model.DoctorSchedule;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Locale;

public class MakeAppointmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int doc_id = Integer.parseInt(req.getParameter("doc_id"));
        AppointmentDao appointmentDao = new AppointmentDao();
        Data data;
        try {
            data = appointmentDao.getAvailableAppointment(doc_id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("doctor", data.object2);
        req.setAttribute("available", data.object1);
        req.getRequestDispatcher("/WEB-INF/views/make-appointment.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int doc_id = Integer.parseInt(req.getParameter("doc_id"));
        int patient_id = ((User)req.getSession().getAttribute("acc")).getId();
        int doctor_schedule_id = Integer.parseInt(req.getParameter("doctor_schedule_id"));
        String note = req.getParameter("note");
        AppointmentDao appointmentDao = new AppointmentDao();
        try {
            appointmentDao.addAppointment(patient_id, note, doctor_schedule_id);
            req.setAttribute("success", "Đặt lịch thành công!");
            resp.sendRedirect(req.getContextPath() + "/" + "patient/make-appointment?doc_id=" + doc_id);
        } catch (SQLException | ClassNotFoundException e) {
            req.setAttribute("error", "Đã có lỗi xảy ra!");
            resp.sendRedirect(req.getContextPath() + "/" + "patient/make-appointment?doc_id=" + doc_id);
        }
    }
}
