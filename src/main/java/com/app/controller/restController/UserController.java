package com.app.controller.restController;

import com.app.entity.Order;
import com.app.entity.User;
import com.app.mail.EmailSender;
import com.app.mail.Mail;
import com.app.service.OrderService;
import com.app.service.ProductService;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller()
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private EmailSender emailSender;

    @GetMapping("")
    @ResponseBody
    public User user(Principal principal) {
        return userService.findByEmail(principal.getName());
    }

    @PostMapping("/edit")
    @ResponseBody
    public int editUser(@RequestBody User m_user, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        user.clone(m_user);
        userService.update(user);
        return user.getId();
    }

    @PostMapping("/password")
    @ResponseBody
    public int changePassword(@RequestBody User m_user, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        user.setPassword(m_user.getPassword());
        userService.update(user);
        return user.getId();
    }

    @PostMapping("/mail")
    @ResponseBody
    public boolean sendMail(@RequestBody Mail mail, Principal principal) {
        emailSender.sendMessage(mail, principal.getName());
        return true;
    }

    @PostMapping("/order")
    @ResponseBody
    public int addOrder(@RequestBody Order order) {
        return orderService.add(order).getId();
    }
}
