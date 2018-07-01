package com.codegym.blogger.controller;

import com.codegym.blogger.model.Category;
import com.codegym.blogger.model.User;
import com.codegym.blogger.service.CategoryService;
import com.codegym.blogger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable("id") Long id) {

        ModelAndView modelAndView = new ModelAndView();
        Category category = categoryService.findById(id);
        if (category != null) {
            modelAndView.setViewName("/category/edit");
            modelAndView.addObject("category", category);
        } else {
            modelAndView.setViewName("/error403");
        }
        return modelAndView;

    }

    @PostMapping("/{id}/edit")
    public ModelAndView edit(@ModelAttribute("category") Category category) {
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        categoryService.save(category);
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Category is updated");
        return modelAndView;
    }

}
