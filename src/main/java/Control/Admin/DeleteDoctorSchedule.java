package Control.Admin;

import Dao.DoctorScheduleDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeleteDoctorSchedule extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String url = req.getParameter("url");
        url = url.replace("-", "&");
        url = url.replace("&W", "-W");
        System.out.println(url);
        if (new DoctorScheduleDao().deleteSchedule(id)){
            resp.sendRedirect(req.getContextPath() + "/admin/doctor-schedule-control?"+url);
        }
    }
}
