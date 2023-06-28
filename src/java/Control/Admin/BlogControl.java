/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control.Admin;

import Dao.BlogDao;
import Model.Blog;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)

public class BlogControl extends HttpServlet {

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        BlogDao blogDao = new BlogDao();
        ArrayList<Blog> blogArray;
        try {
            blogArray = blogDao.getAllBlog();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("blog_list", blogArray);
        req.getRequestDispatcher("/WEB-INF/views/admin/blog-control.jsp").forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("_method").equals("DELETE")) {
            this.doDelete(req, resp);
        } else {
        int day = Integer.parseInt(req.getParameter("day"));
        String month = req.getParameter("month");
        String title = req.getParameter("title");
        String scriptS = req.getParameter("scriptshort");
        String scriptF = req.getParameter("scriptfull");
        Part filePart = req.getPart("image");
        String fileName = getFileName(filePart);
        assert fileName != null;
        String newFileName = generateUniqueFileName(fileName);
        String uploadDir = req.getServletContext().getRealPath("/") + "uploadsBlog";
//            Path filePath = Path.of(uploadDir, newFileName);
        Path filePath = Paths.get(uploadDir, newFileName);
        try ( InputStream fileContent = filePart.getInputStream()) {
            Files.copy(fileContent, filePath, StandardCopyOption.REPLACE_EXISTING);
        }
        BlogDao blogDao = new BlogDao();
        boolean check = blogDao.createBlog(day, month, title, scriptS, scriptF, "uploadsBlog/" + newFileName);
        if (check) {
            resp.sendRedirect("blog-control");
        } else {
            req.setAttribute("message", "có lỗi");
            req.getRequestDispatcher("/WEB-INF/views/admin/blog-control.jsp").forward(req, resp);
        }
    }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BlogDao blogDao = new BlogDao();
        int id = Integer.parseInt(req.getParameter("id"));
        blogDao.deleteBlog(id);
        resp.sendRedirect("blog-control");
    }

}
