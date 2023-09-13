package org.example.task5.service.impl;

import org.example.task5.model.Category;
import org.example.task5.repository.CategoryDao;
import org.example.task5.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category get(Long id) {
        return categoryDao.get(id).orElseThrow(
                () -> new RuntimeException("Category with id " + id + " not found")
        );
    }

    @Override
    public Category add(Category category) {
        return categoryDao.add(category);
    }
}
