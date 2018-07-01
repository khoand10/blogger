package com.codegym.blogger.service.impl;

import com.codegym.blogger.model.Category;
import com.codegym.blogger.model.User;
import com.codegym.blogger.repository.CategoryRepository;
import com.codegym.blogger.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Iterable<Category> findAllByCreator(User user) {
        return categoryRepository.findAllByCreator(user);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public boolean hasCategoryPermission(User user, Category category) {
        return user.getId().equals(category.getCreator().getId());
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }
}
