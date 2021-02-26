package controller.Admin;

import model.Category;
import service.admin.CategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminEditCategoruServlet", urlPatterns = "/editCategory")
public class AdminEditCategoryServlet extends HttpServlet {
    CategoryService categoryService = new CategoryService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        int id = Integer.parseInt(request.getParameter("cateId"));
        String categoryName = request.getParameter("categoryName");

        Category category = new Category(categoryName);

        try {
            categoryService.update(category,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("mess", "Done...!!!");
        request.setAttribute("category",category);

        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-assets/editCategory.jsp");
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        int id = Integer.parseInt(request.getParameter("id"));
        Category category = null;

        try {
            category = categoryService.findByID(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-assets/editCategory.jsp");
        request.setAttribute("category",category);
        dispatcher.forward(request, response);
    }
}
