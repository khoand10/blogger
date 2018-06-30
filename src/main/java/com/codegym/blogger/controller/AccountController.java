package com.codegym.blogger.controller;

import com.codegym.blogger.model.User;
import com.codegym.blogger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {

    private UserService userService;

    @Autowired
    public AccountController(UserService userService) {
        super(userService);
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView accountInfo() {
        ModelAndView modelAndView = new ModelAndView("/users/information");
        User user = getUserAuthenticated();
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
