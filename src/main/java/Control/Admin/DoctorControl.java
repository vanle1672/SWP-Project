package Control.Admin;

import Dao.DoctorDao;
import Dao.SpecialityDao;
import Model.Doctor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100  // 100 MB
)
public class DoctorControl extends HttpServlet {
    public String generateUniqueFileName(String originalFileName) {
        // Get the file extension from the original filename
        String extension = "";
        int dotIndex = originalFileName.lastIndexOf('.');
        if (dotIndex >= 0 && dotIndex < originalFileName.length() - 1) {
            extension = originalFileName.substring(dotIndex + 1);
        }

        // Generate a random UUID as the unique part of the filename
        String uniquePart = UUID.randomUUID().toString();

        // Combine the unique part and file extension to create the unique filename
        String uniqueFileName = uniquePart + "." + extension;

        return uniqueFileName;
    }
    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] tokens = contentDisposition.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 1).trim()
                        .replace("\"", "");
            }
        }
        return null;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DoctorDao doctorDao = new DoctorDao();
        SpecialityDao specialityDao = new SpecialityDao();
        ArrayList<Doctor> doctorArrayList;
        try {
            doctorArrayList = doctorDao.getAllDoctor();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("doctor_list", doctorArrayList);
        req.setAttribute("speciality_list", specialityDao.getAllSpeciality());
        req.getRequestDispatcher("/WEB-INF/views/admin/doctor-control.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("_method").equals("DELETE")){
            this.doDelete(req,resp);
        } else {
            boolean gender = false;
            if (req.getParameter("gender").equals("1")){
                gender = true;
            }
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String degree = req.getParameter("degree");
            int experience = Integer.parseInt(req.getParameter("experience"));
            int speciality_id = Integer.parseInt(req.getParameter("speciality_id"));
            String phone = req.getParameter("phone");
            String dob = req.getParameter("dob");

            String address = req.getParameter("address");

            Part filePart = req.getPart("image");
            String fileName = getFileName(filePart);
            assert fileName != null;
            String newFileName = generateUniqueFileName(fileName);
            String uploadDir = req.getServletContext().getRealPath("/") + "uploads";
//            Path filePath = Path.of(uploadDir, newFileName);
            Path filePath = Paths.get(uploadDir, newFileName);
            try (InputStream fileContent = filePart.getInputStream()) {
                Files.copy(fileContent, filePath, StandardCopyOption.REPLACE_EXISTING);
            }
            DoctorDao doctorDao = new DoctorDao();
            boolean check = doctorDao.createDoctor(name, email, password, degree, experience, speciality_id, "uploads/" + newFileName, phone, dob, gender, address);
            if (check){
                resp.sendRedirect("doctor-control");
            } else {
                req.setAttribute("message", "có lỗi");
                req.getRequestDispatcher("/WEB-INF/views/admin/doctor-control.jsp").forward(req, resp);
            }
        }
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DoctorDao doctorDao = new DoctorDao();
        if (doctorDao.deleteDoctor(Integer.parseInt(req.getParameter("id")))){
            resp.sendRedirect("doctor-control");
        }
    }
}
