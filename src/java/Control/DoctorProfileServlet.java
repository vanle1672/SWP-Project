package Control;

import Dao.DoctorDao;
import Dao.SpecialityDao;
import Model.Doctor;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class DoctorProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Doctor doctor = (Doctor) req.getAttribute("doctor");
        req.setAttribute("doctor", doctor);
         req.setAttribute("speciality_list", new SpecialityDao().getAllSpeciality());
        req.getRequestDispatcher("/WEB-INF/views/doctor/profile.jsp").forward(req,resp);
    }
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Doctor doctor = (Doctor) session.getAttribute("doctor");
        int id = doctor.getId();
        String name = req.getParameter("name");
        String degree = req.getParameter("degree");
        int experience = Integer.parseInt(req.getParameter("experience"));
        int specialty   = Integer.parseInt(req.getParameter("specialty"));
        String phone = req.getParameter("phone");
        String dob = req.getParameter("DOB");
        boolean gender = false;
        if (req.getParameter("gender").equals("1")){
            gender = true;
        }
        String address = req.getParameter("address");       
        DoctorDao doctordao = new DoctorDao();
        if(doctordao.updateDoctor( name, degree, experience, specialty, phone, dob, gender, address,id)){
            Doctor dr = doctordao.findById(id);
            req.getSession().setAttribute("doctor", dr);
            resp.sendRedirect(req.getContextPath() + "/doctor/profile");
        }
    }
}
