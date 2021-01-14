package vn.managebook.demo.services;

import vn.managebook.demo.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    void save(Book book);
    void update(Book book);
    Book findById(int id);
}
