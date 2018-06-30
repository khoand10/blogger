package com.codegym.blogger.service;

import com.codegym.blogger.model.User;

public interface UserService {

    void save(User user);

    boolean existEmail(String email);

    User findByEmail(String email);
}
