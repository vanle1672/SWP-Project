/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control;

import Dao.BlogDao;
import Model.Blog;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author ASUS
 */
public class DetailBlogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            BlogDao blogdao = new BlogDao();
            String bid = req.getParameter("bid");
            Blog blogdetail = blogdao.getBlogByID(bid);
            req.setAttribute("detail", blogdetail);
            req.getRequestDispatcher("/WEB-INF/views/blogDetail.jsp").forward(req, resp);
        } catch (Exception e) {
        }
    }
}
