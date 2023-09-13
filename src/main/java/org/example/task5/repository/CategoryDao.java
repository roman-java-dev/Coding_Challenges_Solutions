package org.example.task5.repository;

import org.example.task5.model.Category;

import java.util.Optional;

public interface CategoryDao {
    Optional<Category> get(Long id);

    Category add(Category category);
}
