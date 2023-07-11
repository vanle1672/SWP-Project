package Control;

import Dao.AppointmentDao;
import Model.Data;
import Model.Doctor;
import Model.Status;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DoctorViewAppointment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int app_id = Integer.parseInt(req.getParameter("app_id")); //lấy giá trị của tham số app_id từ yêu cầu và chuyển đổi nó thành kiểu số nguyên.
        Doctor doctor= (Doctor) req.getSession().getAttribute("doctor"); //lấy đối tượng Doctor từ session bằng cách sử dụng phương thức getAttribute với tên thuộc tính là "doctor".
        if (req.getSession().getAttribute("session_para")!=null)//Dòng này kiểm tra xem có thuộc tính "session_para" trong session hay không. Nếu có, nó lấy giá trị của thuộc tính và gán vào biến a.
        {
            String a = (String)req.getSession().getAttribute("session_para");
            req.setAttribute(a.split("\\|")[0], a.split("\\|")[1]);//phương thức split của chuỗi để tách giá trị của a thành một mảng, sử dụng ký tự "|" làm dấu phân cách.
            req.getSession().removeAttribute("session_para");
        }
        Data data;
        try {
            data = new AppointmentDao().getDetail(app_id, doctor.id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (data != null){
            req.setAttribute("app", data.object1);
            req.setAttribute("patient", data.object2);
            req.setAttribute("time", data.object3);
            req.getRequestDispatcher("/WEB-INF/views/doctor/doctor-view-appointment.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "Đã có lỗi xảy ra hoặc đây không phải là cuộc hẹn của bạn!");
            req.getRequestDispatcher("/WEB-INF/views/doctor/doctor-view-appointment.jsp").forward(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String status = req.getParameter("status");
        int app_id = Integer.parseInt(req.getParameter("app_id"));
        Doctor doctor= (Doctor) req.getSession().getAttribute("doctor");
        AppointmentDao appointmentDao = new AppointmentDao();
        try {
            Status.valueOf(status);//Kiểm tra giá trị của biến status có thuộc vào danh sách các giá trị hợp lệ hay không bằng cách sử dụng Status.valueOf(status).
            if (appointmentDao.updateAppointmentStatus(status, app_id, doctor.id)){
//                req.getSession().setAttribute("session_para", "success|Thay đổi thành công!");
//                resp.sendRedirect(req.getContextPath() + "/doctor/appointment-detail?app_id=" + app_id);
                resp.sendRedirect(req.getContextPath() + "/doctor/schedule");
            } else {
                req.getSession().setAttribute("session_para", "error|Thay đổi Thất bại!");
                resp.sendRedirect(req.getContextPath() + "/doctor/appointment-detail?app_id=" + app_id);
            }
        } catch (IllegalArgumentException e){
            req.getSession().setAttribute("session_para", "success|Thay đổi Thất bại!");
            resp.sendRedirect(req.getContextPath() + "/doctor/appointment-detail?app_id=" + app_id);
        }
    }
}

/*Kiểm tra giá trị của biến status có thuộc vào danh sách các giá trị hợp lệ hay không bằng cách sử dụng Status.valueOf(status). 
Nếu giá trị hợp lệ, tiếp tục thực hiện các bước sau, nếu không, điều hướng đến trang xử lý lỗi.
Gọi phương thức updateAppointmentStatus trong AppointmentDao để cập nhật trạng thái của cuộc hẹn. Truyền vào các tham số: status, app_id, và doctor.id.
Nếu việc cập nhật thành công, 
điều hướng người dùng đến trang "/doctor/schedule" bằng phương thức resp.sendRedirect.
Nếu việc cập nhật không thành công, 
gán giá trị cho thuộc tính session_para là "error|Thay đổi Thất bại!" và điều hướng người dùng đến trang "/doctor/appointment-detail?app_id=" + app_id.
Nếu giá trị của biến status không thuộc vào danh sách các giá trị hợp lệ, gán giá trị cho thuộc tính session_para là "success|Thay đổi Thất bại!" 
và điều hướng người dùng đến trang "/doctor/appointment-detail?app_id=" + app_id.*/