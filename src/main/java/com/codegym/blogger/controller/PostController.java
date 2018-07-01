package com.codegym.blogger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/posts")
public class PostController {

    @GetMapping("")
    @ResponseBody
    public String index(){
        return "hello";
    }

}
