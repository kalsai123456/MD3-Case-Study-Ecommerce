package controller;

import model.User;
import service.IUserDAO;
import service.UserDAO;

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
            case "loginSuccess":
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                if(userDAO.checkLogin(username, password)){
                    showHome(req, resp);
                    break;
                } else {
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/login.jsp");
                    req.setAttribute("mes", "Tai khoan sai");
                    requestDispatcher.forward(req, resp);
                }
                }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        int userid = Integer.parseInt(req.getParameter("iduser"));
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        userDAO.add(new User(userid,name,username,password));
        System.out.println(new User(userid,name,username,password));
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
    private void showHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/home.jsp");
        requestDispatcher.forward(req, resp);
    }


}
