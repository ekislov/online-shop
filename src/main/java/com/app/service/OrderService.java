package com.app.service;

import com.app.dao.OrderDAO;
import com.app.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderDAO orderDAO;

    public List findAll() {
        return orderDAO.findAll();
    }

    public Order add(Order order) {
        return orderDAO.save(order);
    }
}
