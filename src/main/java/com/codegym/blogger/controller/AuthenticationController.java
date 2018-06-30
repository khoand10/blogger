package com.codegym.blogger.controller;

import com.codegym.blogger.model.User;
import com.codegym.blogger.model.UserForm;
import com.codegym.blogger.service.UserService;
import com.codegym.blogger.until.StorageUtils;
import com.codegym.blogger.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.UUID;

@Controller
public class AuthenticationController {

    private UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/login"})
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/users/login");
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/users/register");
        modelAndView.addObject("userForm", new UserForm());
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView saveUser(@ModelAttribute("userForm") UserForm userForm) {
        ModelAndView modelAndView = new ModelAndView("/users/login");
        User user = new User();

        try {
            String randomCode = UUID.randomUUID().toString();
            String originFileName = userForm.getAvatar().getOriginalFilename();
            String randomName = randomCode + StorageUtils.getFileExtension(originFileName);
            userForm.getAvatar().transferTo(new java.io.File(StorageUtils.FEATURE_LOCATION + "/" + randomName));

            user.setId(userForm.getId());
            user.setName(userForm.getName());
            user.setAge(userForm.getAge());
            user.setEmail(userForm.getEmail());
            user.setJob(userForm.getJob());
            user.setPassword(userForm.getPassword());
            user.setAvatar(randomName);
            userService.save(user);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return modelAndView;
    }
}
