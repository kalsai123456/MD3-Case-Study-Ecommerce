package service;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void add (User user) throws SQLException;
    public User findById (int id);
    public List<User> findAll() throws SQLException;
    public boolean delete(int id) throws  SQLException;

    public boolean deleteUser(int id) throws SQLException;

    void delete(User user);

    public boolean update (User user) throws SQLException;
    public boolean checkLogin(String username, String password);
}
