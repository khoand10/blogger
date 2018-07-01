package com.codegym.blogger.service;

import com.codegym.blogger.model.Post;
import com.codegym.blogger.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {

    Page<Post> findAllByCreator(Pageable pageable, User user);

    Iterable<Post> findAllByCreator(User user);

}
