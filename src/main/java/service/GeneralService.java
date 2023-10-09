package service;

import java.sql.Connection;
import java.util.List;

public interface GeneralService <T> {
    Connection getConnection();
    List<T> findAll();
    T findById(int id) throws RuntimeException;
    List<T> findByName(String name);
    void update(T t);
    void save(T t);
    void delete(T t);
}
