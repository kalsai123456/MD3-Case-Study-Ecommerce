package controller;

import model.User;
import service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns ="/users")
public class UserServlet extends HttpServlet {
    IUserDAO userDAO = new UserDAO();
    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("act");
        if (action == null){
            action = "";
        }

        try {
        switch (action){
            case "create":
                save(req, resp);
                break;
            case "edit":
                updateUser(req, resp);
                break;
            case "loginSuccess":
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                if(userDAO.checkLogin(username, password)){
                    showHome(username, req, resp);
                    break;
                } else {
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/login.jsp");
                    req.setAttribute("mes", "Sai ten dang nhap hoac mat khau");
                    requestDispatcher.forward(req, resp);
                }
                }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
//        int userid = Integer.parseInt(req.getParameter("iduser"));
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        userDAO.add(new User(name,username,password));
        System.out.println(new User(name,username,password));
        resp.sendRedirect("/users?act=login");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("act");
        if (action == null){
            action = "";
        }
        try {
        switch (action){
            case "create":
                showSignUpForm(req, resp);
                break;
            case "login":
                showLoginForm(req, resp);
                break;
           case "listUser":
               showListUser(req, resp);
               break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                deleteUser(req,resp);
                break;

        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void showListUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/list.jsp");
        List<User> users = userDAO.findAll();
        req.setAttribute("dsUS", users);
        requestDispatcher.forward(req, resp);
    }


    private void showSignUpForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/sign-up.jsp");
        requestDispatcher.forward(req, resp);
    }
    private void showLoginForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/login.jsp");
        requestDispatcher.forward(req, resp);
    }
    private void showHome(String username,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/product/list.jsp");
        req.setAttribute("username", username);
        req.setAttribute("products", productService.findAll());
        req.setAttribute("categories", categoryService.findAll());
        requestDispatcher.forward(req, resp);
    }
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/list.jsp");
        List<User> users = userDAO.findAll();
        request.setAttribute("dsUS", users);
        requestDispatcher.forward(request, response);

    }
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        User updateUser = new User(id, name, userName, password);
        userDAO.update(updateUser);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/edit.jsp");
        requestDispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDAO.findById(id);
        request.setAttribute("user",existingUser);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/edit.jsp");
        requestDispatcher.forward(request, response);
    }
}





