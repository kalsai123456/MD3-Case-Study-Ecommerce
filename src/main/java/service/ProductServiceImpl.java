package service;

import model.Category;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ProductServiceImpl implements ProductService {
    CategoryService categoryService = new CategoryServiceImpl();
    public ProductServiceImpl() {
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
    public Product findById(int id) throws RuntimeException {
        Product product = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where idProduct = ?");
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("idProduct");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                String img = rs.getString("img");
                String description = rs.getString("description");
                int idCategory = rs.getInt("idCategory");
                Category category = categoryService.findById(idCategory);
                product = new Product(idProduct, name, quantity, price, category, img, description);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public List<Product> findByName(String nameSearch) {
        List<Product> products = new ArrayList<>();
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where name like ?");
            preparedStatement.setString(1,"%" + nameSearch + "%");
//            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("idProduct");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                String img = rs.getString("img");
                String description = rs.getString("description");
                int idCategory = rs.getInt("idCategory");
                Category category = categoryService.findById(idCategory);
                products.add(new Product(idProduct, name, quantity, price, category, img, description));
            }
        }
        catch (SQLException e){
            e.printStackTrace(System.err);
        }
        return products;
    }

    @Override
    public void update(Product product) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update product set name = ?, quantity = ?, price = ?, img = ?, description = ?, idCategory = ? where idProduct = ?");
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getQuantity());
            preparedStatement.setDouble(3,product.getPrice());
            preparedStatement.setString(4,product.getImg());
            preparedStatement.setString(5,product.getDescription());
            preparedStatement.setInt(6,product.getCategory().getIdCategory());
            preparedStatement.setInt(7,product.getIdProduct());
            preparedStatement.executeUpdate();
            System.out.println(preparedStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("idProduct");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                String img = rs.getString("img");
                String description = rs.getString("description");
                int idCategory = rs.getInt("idCategory");
                Category category = categoryService.findById(idCategory);
                products.add(new Product(idProduct, name, quantity, price, category, img, description));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public void save(Product product) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into product(name, quantity, price, img, description, idCategory) values (?, ?, ?, ?, ?, ?)");
            System.out.println(preparedStatement);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getQuantity());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setString(4, product.getImg());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getCategory().getIdCategory());
            preparedStatement.executeUpdate();
            System.out.println(preparedStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findByIdCategory(int idCategory) {
        List<Product> products = new ArrayList<>();
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where idCategory = ?");
            preparedStatement.setInt(1,idCategory);
//            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("idProduct");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                String img = rs.getString("img");
                String description = rs.getString("description");
                int idCategory1 = rs.getInt("idCategory");
                Category category = categoryService.findById(idCategory);
                products.add(new Product(idProduct, name, quantity, price, category, img, description));
            }
        }
        catch (SQLException e){
            e.printStackTrace(System.err);
        }
        return products;
    }

    @Override
    public void delete(Product product) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from product where idProduct = ?");
            preparedStatement.setInt(1, product.getIdProduct());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Product> sortByPrice(double min, double max) {
        return null;
    }
}
