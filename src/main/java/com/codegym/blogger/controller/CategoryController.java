package com.codegym.blogger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @GetMapping("/")
    public ModelAndView listCategory(){
        ModelAndView modelAndView = new ModelAndView("/category/list");
        return modelAndView;
    }

}
