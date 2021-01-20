package com.phucle.demo.services;

import com.phucle.demo.model.Category;
import com.phucle.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Category> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public void create(Category category) {
        cartRepository.save(category);
    }

    @Override
    public void update(Category category) {
        cartRepository.save(category);
    }

    @Override
    public void delete(Category category) {
        cartRepository.delete(category);
    }

    @Override
    public Category findById(long id) {
        return cartRepository.findById(id).orElse(null);
    }
}
