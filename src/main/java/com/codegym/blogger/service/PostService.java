package com.codegym.blogger.service;

import com.codegym.blogger.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {

    Page<Post> findAllByCreator(Pageable pageable);

    Iterable<Post> findAllByCreator();

}
