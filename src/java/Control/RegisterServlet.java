package Control;
import Dao.PatientDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

public class RegisterServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(request, response);
//        request.getRequestDispatcher("/WEB-INF/views/auth/login_new.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String name = request.getParameter("name");
        System.out.println("name : " + name);
        String confirmpass = request.getParameter("confirm");
        String phone = request.getParameter("phone");
        String dob = request.getParameter("dob");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String address = request.getParameter("address");
        String verify_key = UUID.randomUUID().toString();
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,50}$";
        if (!pass.matches(passwordRegex)) {
            request.setAttribute("mess", "Mật khẩu phải có 8-50 kí tự, bao gồm ít nhất một chữ hoa, một chữ thường và một số!");
            request.setAttribute("status", "error");
            request.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(request, response);
        } else if (!pass.equals(confirmpass)) {
            request.setAttribute("mess", "Mật khẩu không trùng khớp!");
            request.setAttribute("status", "error");
            request.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(request, response);
        } else {
            PatientDao patientDao = new PatientDao();
            boolean checkMail = false;
            try {
                checkMail = patientDao.emailExist(email);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            if (!checkMail) {
                try {
                    boolean check = patientDao.createUser(name, email, pass, phone, verify_key, address, dob, gender);
                    if (check) {
                        request.setAttribute("mess", "Đăng kí thành công!");
                        request.setAttribute("status", "success");
                        request.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(request, response);
                    } else {
                        request.setAttribute("mess", "Đã có lỗi xảy ra, vui lòng liên hệ xxx!");
                        request.setAttribute("status", "error");
                        request.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(request, response);
                    }
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                request.setAttribute("mess", "Email đã tồn tại!");
                request.setAttribute("status", "error");
                request.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(request, response);
            }
        }
    }
}
