package com.onlineshop.onlineshop.service.impl;

import com.onlineshop.onlineshop.model.Category;
import com.onlineshop.onlineshop.repository.InMemoryCategoryRepository;
import com.onlineshop.onlineshop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    private final InMemoryCategoryRepository categoryRepository;
    public CategoryServiceImpl(InMemoryCategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }

    @Override
    public Category create(String name, String description) {
        if (name==null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Category c = new Category(name,description);
        categoryRepository.save(c);
        return c;

    }

    @Override
    public Category update(String name, String description) {
        if (name==null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Category c= new Category(name,description);
        categoryRepository.save(c);
        return c;

    }

    @Override
    public void delete(String name) {
        if (name==null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        categoryRepository.delete(name);
    }

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> searchcategories(String searchText) {
        return categoryRepository.search(searchText);
    }
}
