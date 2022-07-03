package com.czy.blog.service;

import com.czy.blog.po.User;

public interface UserService {
    User checkUser(String username, String password);  //检查用户名和密码
}
