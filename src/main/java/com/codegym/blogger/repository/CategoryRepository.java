package com.codegym.blogger.repository;

import com.codegym.blogger.model.Category;
import com.codegym.blogger.model.User;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Iterable<Category> findAllByCreator(User user);

}
