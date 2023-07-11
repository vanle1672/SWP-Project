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
import java.util.ArrayList;

public class SearchBlog extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
       try {
             BlogDao blogdao = new BlogDao();
             String txtSearch = req.getParameter("txt");
             ArrayList<Blog> searchBlog = blogdao.searchBlog(txtSearch);           
             if(searchBlog.isEmpty()){
                 String none = "Không tìm thấy dữ liệu nào phù hợp!";
                 req.setAttribute("none", none);
                 
             } else {
                  req.setAttribute("SearchBlog", searchBlog);
             }
             
              req.getRequestDispatcher("/WEB-INF/views/blog.jsp").forward(req, resp);
        } catch (Exception e) {
        }
    }
    }

    

