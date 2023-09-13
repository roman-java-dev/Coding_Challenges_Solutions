package org.example.task5.service;

import org.example.task5.model.Category;

public interface CategoryService {
    Category get(Long id);

    Category add(Category category);
}
