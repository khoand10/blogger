package com.codegym.blogger.service;

import com.codegym.blogger.model.Category;
import com.codegym.blogger.model.User;

public interface CategoryService {

    Iterable<Category> findAllByCreator(User user);

    void save(Category category);

    boolean hasCategoryPermission(User user, Category category);

    Category findById(Long id);
}
