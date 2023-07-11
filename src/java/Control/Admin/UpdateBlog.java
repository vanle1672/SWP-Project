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
import java.util.ArrayList;

import java.util.UUID;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class UpdateBlog extends HttpServlet {

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
        String blog_id = req.getParameter("blog_id");
        BlogDao blogDao = new BlogDao();
        try {
            Blog blogid = blogDao.getBlogByID(blog_id);
            req.setAttribute("blog", blogid);
        } catch (Exception e) {
        }
        req.getRequestDispatcher("/WEB-INF/views/admin/update-blog.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("blogid"));
        int day = Integer.parseInt(req.getParameter("update_day"));
        String month = req.getParameter("update_month");
        String title = req.getParameter("update_title");
        String scriptS = req.getParameter("update_scriptshort");
        String scriptF = req.getParameter("update_scriptfull");
        Part filePart = req.getPart("update_image");
        BlogDao blogDao = new BlogDao();

        if (filePart != null && filePart.getSize() > 0) {
            String fileName = getFileName(filePart);
            assert fileName != null;
            String newFileName = generateUniqueFileName(fileName);
            String uploadDir = req.getServletContext().getRealPath("/") + "uploadsBlog";
            Path filePath = Paths.get(uploadDir, newFileName);
            try ( InputStream fileContent = filePart.getInputStream()) {
                Files.copy(fileContent, filePath, StandardCopyOption.REPLACE_EXISTING);
            }
            if (blogDao.UpdateBlogImg(id, day, month, title, scriptS, scriptF, "uploadsBlog/" + newFileName)) {
                resp.sendRedirect(req.getContextPath() + "/admin/blog-control");
            } else { // thay đổi lỗi
                req.setAttribute("error", "đã có lỗi xảy ra");
                String blog_id = req.getParameter("blog_id");

                try {
                    Blog blogArray = blogDao.getBlogByID(blog_id);
                    req.setAttribute("blog", blogArray);
                } catch (Exception e) {
                }
                req.getRequestDispatcher("/WEB-INF/views/admin/update-doctor.jsp").forward(req, resp);
            }
        } else {
            if (blogDao.UpdateBlogNoImg(id, day, month, title, scriptS, scriptF)) {
                resp.sendRedirect(req.getContextPath() + "/admin/blog-control");
            } else { // thay đổi lỗi
                req.setAttribute("error", "đã có lỗi xảy ra");
                String blog_id = req.getParameter("blog_id");
                try {
                    Blog blogArray = blogDao.getBlogByID(blog_id);
                    req.setAttribute("blog", blogArray);
                } catch (Exception e) {
                }
                req.getRequestDispatcher("/WEB-INF/views/admin/update-doctor.jsp").forward(req, resp);
            }
        }
    }

}
