package com.app.controller.restController;

import com.app.entity.User;
import com.app.service.ProductService;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PublicController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;


    @GetMapping("products")
    @ResponseBody
    public List products() {
        return productService.findAll();
    }

    @GetMapping("products/from={from}&to={to}")
    @ResponseBody
    public List productsPriceBetween(@PathVariable("from") int from, @PathVariable("to") int to) {
        return productService.findPriceBetween(from, to);
    }

    @PostMapping("register")
    @ResponseBody
    public int register(@RequestBody User user) {
        return userService.add(user).getId();
    }
}
