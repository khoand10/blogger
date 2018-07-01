package com.codegym.blogger.service.impl;

import com.codegym.blogger.model.Post;
import com.codegym.blogger.repository.PostRepository;
import com.codegym.blogger.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public Page<Post> findAllByCreator(Pageable pageable) {
        return null;
    }

    @Override
    public Iterable<Post> findAllByCreator() {
        return null;
    }
}
