package controller.Admin;

import model.Category;
import model.Post;
import service.admin.CategoryService;
import service.admin.PostService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminEditPostServlet", urlPatterns = "/editPost")
public class AdminEditPostServlet extends HttpServlet {
    PostService postService = new PostService();
    CategoryService categoryService = new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        int id = Integer.parseInt(request.getParameter("postid"));
        String title = request.getParameter("title");
        String fullContent = request.getParameter("fullContent");
        String shortContent = request.getParameter("shortContent");
        String image = request.getParameter("image");

        int categoryID = Integer.parseInt(request.getParameter("category"));

        Category category = new Category(categoryID);
        Post post = new Post(title,fullContent,shortContent,image,category);

        try {
            postService.update(post,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Post post1 = null;
        List<Category> categoryList = null;

        try {
            post1 = postService.findByID(id);
            categoryList = categoryService.showAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-assets/editPost.jsp");
        request.setAttribute("mess","Done...!!!");
        request.setAttribute("post",post1);
        request.setAttribute("category",categoryList);
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        int id = Integer.parseInt(request.getParameter("id"));
        List<Category> categoryList = null;
        Post post = null;
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-assets/editPost.jsp");

        try {
            post = postService.findByID(id);
            categoryList = categoryService.showAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("post",post);
        request.setAttribute("category",categoryList);
        dispatcher.forward(request,response);


    }
}
