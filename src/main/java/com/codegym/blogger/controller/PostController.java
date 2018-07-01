package com.codegym.blogger.controller;

import com.codegym.blogger.model.Post;
import com.codegym.blogger.model.User;
import com.codegym.blogger.service.PostService;
import com.codegym.blogger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/posts")
public class PostController extends BaseController {

    private PostService postService;

    @Autowired
    public PostController(UserService userService, PostService postService) {
        super(userService);
        this.postService = postService;
    }

    @GetMapping("")
    public ModelAndView showListPost(Pageable pageable) {

        ModelAndView modelAndView = new ModelAndView("/post/list");
        User userAuthenticated = getUserAuthenticated();
        Iterable<Post> posts = postService.findAllByCreator(pageable, userAuthenticated);
        return modelAndView;

    }

}
