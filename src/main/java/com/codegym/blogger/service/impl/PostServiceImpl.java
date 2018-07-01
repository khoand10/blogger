package com.codegym.blogger.service.impl;

import com.codegym.blogger.model.Post;
import com.codegym.blogger.model.User;
import com.codegym.blogger.repository.PostRepository;
import com.codegym.blogger.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Page<Post> findAllByCreator(Pageable pageable, User user) {
        return postRepository.findAllByCreator(pageable, user);
    }

    @Override
    public Iterable<Post> findAllByCreator(User user) {
        return postRepository.findAllByCreator(user);
    }
}
