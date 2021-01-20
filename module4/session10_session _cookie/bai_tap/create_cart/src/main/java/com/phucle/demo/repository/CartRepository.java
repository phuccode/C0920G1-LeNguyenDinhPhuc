package com.phucle.demo.repository;

import com.phucle.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Category, Long> {
}
