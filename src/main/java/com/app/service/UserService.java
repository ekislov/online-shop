package com.app.service;

import com.app.dao.UserDAO;
import com.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public List findAll() {
        return userDAO.findAll();
    }

    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    public User add(User user) {
        return userDAO.saveAndFlush(user);
    }

    public void update(User user) {
        userDAO.flush();
    }
}
