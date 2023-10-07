package controller;

import model.Category;
import model.Product;
import service.CategoryService;
import service.CategoryServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/categories")
public class CategoryServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "edit":
                showFormEdit(request,response);
                break;
            case "findByName":
                showListByName(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("category/edit.jsp");
        int idCategory = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.findById(idCategory);
        request.setAttribute("category", category);
        requestDispatcher.forward(request, response);
        showList(request, response);
    }
    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/list.jsp");
        List<Category> categories = categoryService.findAll();
        request.setAttribute("categories", categories);
        dispatcher.forward(request, response);
    }
    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("category/create.jsp");
        requestDispatcher.forward(request, response);
    }
    private void showListByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("category/list.jsp");
        String nameSearch = request.getParameter("nameSearch");
        List<Category> categories = categoryService.findByName(nameSearch);
        request.setAttribute("categories", categories);
        requestDispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCategory(request, response);
                break;
            case "edit":
                editCategory(request,response);
//            case "showByCategory":
//                showByCategory(request, response);
//                break;
        }
    }
    private void createCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        Category category = new Category(1, name);
        categoryService.save(category);
        showList(request, response);
    }
    private void editCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idCategory = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Category category = new Category(idCategory, name);
        categoryService.update(category);
        showList(request, response);
    }
}