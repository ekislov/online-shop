package com.app.dao;

import com.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProductDAO extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM product p WHERE p.price BETWEEN :from AND :to")
    List findPriceBetween(@Param("from") int from, @Param("to") int to);

}
