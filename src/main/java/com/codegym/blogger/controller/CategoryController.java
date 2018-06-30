package com.codegym.blogger.controller;

import com.codegym.blogger.model.Category;
import com.codegym.blogger.model.User;
import com.codegym.blogger.service.CategoryService;
import com.codegym.blogger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/categories")
public class CategoryController extends BaseController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(UserService userService, CategoryService categoryService) {
        super(userService);
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public ModelAndView listCategory() {
        ModelAndView modelAndView = new ModelAndView("/category/list");
        User user = getUserAuthenticated();
        Iterable<Category> categories = categoryService.findAllByCreator(user);
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateform() {
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("category") Category category) {

        User user = getUserAuthenticated();
        category.setCreator(user);
        ModelAndView modelAndView = new ModelAndView("/category/create");
        categoryService.save(category);
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("successMessage", "Create new success");
        return modelAndView;
    }

}
