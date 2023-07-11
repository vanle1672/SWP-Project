package Control;
import Dao.BlogDao;
import Model.Blog;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class BlogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            BlogDao blogdao = new BlogDao();
            ArrayList<Blog> showallblog = blogdao.getAllBlog();
            req.setAttribute("showblog", showallblog);
            req.getRequestDispatcher("/WEB-INF/views/blog.jsp").forward(req, resp);
        } catch (Exception e) {
        }
    }
}
