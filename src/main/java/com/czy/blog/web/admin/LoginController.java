package com.czy.blog.web.admin;

import com.czy.blog.po.User;
import com.czy.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * 登录控制器
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;  //service注入

    @GetMapping
    public String loginPage(){  //跳转到登录页面
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,
                        HttpSession session, RedirectAttributes attributes){    //登录方法
        User user = userService.checkUser(username,password);
        if(user != null){
            user.setPassword(null);      //避免密码传到页面中
            session.setAttribute("user",user);
            return "admin/index";
        }else{
            attributes.addFlashAttribute("message","用户名或密码错误");
            return "redirect:/admin";     //页面重定位
        }

    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {   //登出
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
