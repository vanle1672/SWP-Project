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
        HttpSession session = req.getSession();//lấy đối tượng HttpSession từ đối tượng HttpServletRequest để làm việc với phiên của người dùng
        Doctor doctor = (Doctor) session.getAttribute("doctor");//lấy đối tượng bác sĩ từ thuộc tính "doctor" của HttpSession. Đây là cách lấy thông tin bác sĩ đã được lưu trong phiên.
        int id = doctor.getId();
        String name = req.getParameter("name");//lấy giá trị của tham số "name" từ đối tượng HttpServletRequest. Đây là tên mới của bác sĩ sau khi được cập nhật.
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
/*Dòng này gọi phương thức updateDoctor của đối tượng DoctorDao để cập nhật thông tin bác sĩ với các tham số tương ứng.
Nếu việc cập nhật thành công, điều kiện trong câu lệnh if sẽ trả về giá trị true.
Doctor dr = doctordao.findById(id);

Dòng này gọi phương thức findById của đối tượng DoctorDao để lấy thông tin bác sĩ đã được cập nhật từ cơ sở dữ liệu.
req.getSession().setAttribute("doctor", dr);

Dòng này cập nhật thuộc tính "doctor" của HttpSession với thông tin bác sĩ đã được cập nhật.
resp.sendRedirect(req.getContextPath() + "/doctor/profile");

Dòng này chuyển hướng người dùng đến trang /doctor/profile sau khi thông tin bác sĩ đã được cập nhật thành công.





*/