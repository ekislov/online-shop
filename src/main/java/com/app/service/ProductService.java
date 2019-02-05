package com.app.service;

import com.app.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;

    public List findAll() {
        return productDAO.findAll();
    }

    public List findPriceBetween(int from, int to) {
        return productDAO.findPriceBetween(from, to);
    }
}
