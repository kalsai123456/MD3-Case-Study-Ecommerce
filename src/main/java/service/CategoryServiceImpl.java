package service;

import model.Category;
import model.Product;
import service.CategoryService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CategoryServiceImpl implements CategoryService {
    public CategoryServiceImpl() {
    }
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce?useSSL=false", "root", "123456");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(System.err);
        }
        return connection;
    }
    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from category");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idCategory = rs.getInt("idCategory");
                String name = rs.getString("name");
                categories.add(new Category(idCategory, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }
    @Override
    public Category findById(int id) {
        Category category = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from category where idCategory = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idCategory = rs.getInt("idCategory");
                String name = rs.getString("name");
                category = new Category(idCategory, name);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        return category;
    }

    @Override
    public List<Category> findByName(String name) {
        List<Category> categories = new ArrayList<>();
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from category where name like ?");
            preparedStatement.setString(1,"%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idCategory = rs.getInt("idCategory");
                String name1 = rs.getString("name");
                categories.add(new Category(idCategory, name1));
            }
        }
        catch (SQLException e){
                e.printStackTrace(System.err);
        }
        return categories;
    }
    public Category findName(String name){
        Category category = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from category where name = ?");
            preparedStatement.setString(1, name);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idCategory = rs.getInt("idCategory");
                String name1 = rs.getString("name");
                category = new Category(idCategory, name1);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        return category;
    }
    @Override
    public void update(Category category) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update category set name = ? where idCategory = ?");
            preparedStatement.setString(1,category.getName());
            preparedStatement.setInt(2,category.getIdCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Category category) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into category(name) values (?)");
            preparedStatement.setString(1, category.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Category category) {
        System.out.println("1");
    }
}
