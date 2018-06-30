package com.codegym.blogger.controller;

import com.codegym.blogger.model.User;
import com.codegym.blogger.model.UserPrincipal;
import com.codegym.blogger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class BaseController {

    private UserService userService;

    @Autowired
    public BaseController(UserService userService){
        this.userService = userService;
    }

    public User getUserAuthenticated() {

        UserPrincipal userPrincipal = getUserPrincipal();
        Long userPrincipalId = userPrincipal.getId();
        User currentUser = userService.findById(userPrincipalId);
        System.out.println(currentUser.toString());
        return currentUser;

    }

    public UserPrincipal getUserPrincipal(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return userPrincipal;

    }

}
