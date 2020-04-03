package com.person.rentalcar.controller;

import com.person.rentalcar.model.User;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.response.RespGenerator;
import com.person.rentalcar.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 * 版本: v1.0.0
 * 日期：2020/1/15 10:52
 * 作者：yejun
 */
@RestController
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

//    @PostMapping(value = "/login")
//    public ApiResponse login(@RequestBody User user) {
//        String username = user.getUsername();
//        // 对HTML标签进行转义，防止XSS攻击
//        username = HtmlUtils.htmlEscape(username);
//        if (!(Objects.equals("admin", username) && Objects.equals("admin", user.getPassword()))) {
//            String message = "账号密码错误";
//            System.out.println("test");
//            return RespGenerator.fail("400").setMessage(message);
//        }
//        return RespGenerator.successful().setMessage("成功");
//
//
//    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody User user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(usernamePasswordToken);
            return RespGenerator.successful(user);
        } catch (IncorrectCredentialsException e) {
            log.error("密码错误");
            return RespGenerator.fail("400").setMessage("密码错误");
        } catch (LockedAccountException e) {
            log.error("该账户被冻结");
            return RespGenerator.fail("400").setMessage("该账户被冻结");
        } catch (UnknownAccountException e) {
            log.error("该用户不存在");
            return RespGenerator.fail("400").setMessage("用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RespGenerator.fail("500");
    }


    @PostMapping(value = "/api/register")
    public ApiResponse<String> register(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping("/api/logout")
    public ApiResponse<String> logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return RespGenerator.successful("成功退出登录状态");
    }

    @GetMapping(value = "api/authentication")
    public String authentication() {
        return "身份认证成功";
    }
}
