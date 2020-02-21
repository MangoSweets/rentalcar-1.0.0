package com.person.rentalcar.controller;

import com.person.rentalcar.model.User;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.response.RespGenerator;
import com.person.rentalcar.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

/**
 * 描述:
 * 版本: v1.0.0
 * 日期：2020/1/15 10:52
 * 作者：yejun
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping(value = "/login")
    public ApiResponse login(@RequestBody User user) {
        String username = user.getUsername();
        // 对HTML标签进行转义，防止XSS攻击
        username = HtmlUtils.htmlEscape(username);
        if (!(Objects.equals("admin", username) && Objects.equals("admin", user.getPassword()))) {
            String message = "账号密码错误";
            System.out.println("test");
            return RespGenerator.fail("400").setMessage(message);
        }
        return RespGenerator.successful().setMessage("成功");


    }

    @CrossOrigin
    @PostMapping(value = "/api/register")
    public ApiResponse<String> register(@RequestBody User user){
        return userService.register(user);
    }

    @GetMapping("/api/logout")
    public ApiResponse<String> logout(){
        Subject subject= SecurityUtils.getSubject();
        subject.logout();
        return  RespGenerator.successful("成功退出登录状态");
    }

    @ResponseBody
    @GetMapping(value = "api/authentication")
    public String authentication(){
        return "身份认证成功";
    }
}
