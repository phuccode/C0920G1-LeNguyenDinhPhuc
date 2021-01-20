package com.phucle.demo.services;

import com.phucle.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CartService {
    //Load List
    List<Category> findAll();

    //Create List
    void create(Category category);


    void update(Category category);

    void delete(Category category);

    Category findById(long id);

}
