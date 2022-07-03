package com.czy.blog.dao;

import com.czy.blog.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
//操作数据库
    User findByUsernameAndPassword(String username, String password);
}
