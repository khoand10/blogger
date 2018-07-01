package com.codegym.blogger.repository;

import com.codegym.blogger.model.Post;
import com.codegym.blogger.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

    Page<Post> findAllByCreator(Pageable pageable, User user);

    Iterable<Post> findAllByCreator(User user);

}
