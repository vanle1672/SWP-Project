package Control;

import Dao.DoctorDao;
import Dao.SpecialityDao;
import Model.Doctor;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchDoctor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SpecialityDao specialityDao = new SpecialityDao();
        req.setAttribute("speciality_list", specialityDao.getAllSpeciality());
        DoctorDao doctordao = new DoctorDao();
        try {
             ArrayList<Doctor> showall = doctordao.getAllDoctor();
             req.setAttribute("showalldoctor", showall);
        } catch (Exception e) {
        }
        req.getRequestDispatcher("/WEB-INF/views/Bacsifull.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println(name);
        int spe_id = Integer.parseInt(req.getParameter("speciality"));
        System.out.println(spe_id);
        DoctorDao doctorDao = new DoctorDao();
        ArrayList<Doctor> doctorArrayList = null;
        try {
            doctorArrayList = doctorDao.searchDoctor(name, spe_id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(doctorArrayList);
        req.setAttribute("showalldoctor", doctorArrayList);
        SpecialityDao specialityDao = new SpecialityDao();
        req.setAttribute("current_spe_id", spe_id);
        req.setAttribute("search_name", name);
        req.setAttribute("speciality_list", specialityDao.getAllSpeciality());
        req.getRequestDispatcher("/WEB-INF/views/Bacsifull.jsp").forward(req,resp);
    }
}
