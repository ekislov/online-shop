package com.app.dao;

import com.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserDAO extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Override
    List<User> findAll();
}
