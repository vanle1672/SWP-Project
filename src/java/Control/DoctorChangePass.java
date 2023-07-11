/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control;

import Dao.DoctorDao;
import Model.Doctor;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author ASUS
 */
public class DoctorChangePass extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/doctor/change-pass.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();//Lấy đối tượng HttpSession từ đối tượng HttpServletRequest để lưu trữ thông tin phiên của người dùng.
        Doctor doctor = (Doctor) session.getAttribute("doctor");//Lấy đối tượng bác sĩ từ HttpSession bằng cách sử dụng tên thuộc tính "doctor".
        int id = doctor.getId();//Lấy ID của bác sĩ từ đối tượng doctor.
        DoctorDao doctorDao = new DoctorDao();//Tạo một đối tượng DoctorDao để thao tác với cơ sở dữ liệu.
        Doctor pass = doctorDao.findById(id);//Tìm kiếm thông tin bác sĩ trong cơ sở dữ liệu dựa trên ID.

//Lấy các giá trị nhập vào từ trường <input> trong biểu mẫu đổi mật khẩu.
        String oldpass = req.getParameter("old-pass");
        String newpass = req.getParameter("new-pass");
        String confirm = req.getParameter("confirm-pass");
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,50}$";// Biểu thức chính quy (regex) để kiểm tra mật khẩu mới.
//Nếu mật khẩu mới không khớp với biểu thức chính quy passwordRegex, đặt thuộc tính "message" là thông báo lỗi và thuộc tính "status" là "error".
        if (!newpass.matches(passwordRegex)) {
            req.setAttribute("message", "Mật khẩu mới phải có 8-50 kí tự, bao gồm ít nhất một chữ hoa, một chữ thường và một số!");
            req.setAttribute("status", "error");
//Nếu mật khẩu cũ không khớp với mật khẩu hiện tại của bác sĩ, đặt thuộc tính "message" là thông báo lỗi và thuộc tính "status" là "error".
        } else if (!pass.getPassword().equals(oldpass)) {
            req.setAttribute("message", "Mật khẩu cũ không đúng!");
            req.setAttribute("status", "error");
 //Nếu mật khẩu mới và xác nhận mật khẩu không khớp, đặt thuộc tính "message" là thông báo lỗi và thuộc tính "status" là "error".           
        } else if (!newpass.equals(confirm)) {
            req.setAttribute("message", "Mật khẩu không trùng khớp!");
            req.setAttribute("status", "error");
 //Nếu tất cả các điều kiện đều đúng, cập nhật mật khẩu mới trong cơ sở dữ liệu bác sĩ và đặt thuộc tính "message" là thông báo thành công và thuộc tính "status" là "success".           
 //Gọi phương thức updatePassDoctor từ đối tượng doctorDao để cập nhật mật khẩu mới cho bác sĩ với ID tương ứng. Phương thức này trả về giá trị true nếu quá trình cập nhật thành công và false nếu có lỗi xảy ra.     
        } else {
            boolean updateResult = doctorDao.updatePassDoctor(id, newpass);
            if (updateResult) {
                req.setAttribute("message", "Thay đổi hoàn tất!");
                req.setAttribute("status", "success");
            } else {
                req.setAttribute("message", "Lỗi hệ thống! Mời bạn thử lại!");
                req.setAttribute("status", "error");
            }
        }

        req.getRequestDispatcher("/WEB-INF/views/doctor/change-pass.jsp").forward(req, resp);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
