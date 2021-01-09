package repository;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CRUD<T> {
    public List<T> selectAll();

    public void insert(T t) throws SQLException;

    public T select(int id);
    
    public T select(String ma_benh_nhan);

    public boolean delete(int id) throws SQLException;

    public boolean update(T t) throws SQLException;

    public List<T> search (String name);
}
