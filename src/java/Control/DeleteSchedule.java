package Control;

import Dao.DoctorScheduleDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeleteSchedule extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        DoctorScheduleDao doctorScheduleDao = new DoctorScheduleDao();
        if (doctorScheduleDao.deleteSchedule(id)){
            resp.sendRedirect(req.getContextPath() + "/doctor/schedule");
        }
    }
}
