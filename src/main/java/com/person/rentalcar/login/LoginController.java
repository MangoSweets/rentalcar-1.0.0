package com.person.rentalcar.login;

import com.alibaba.fastjson.JSONObject;
import com.person.rentalcar.constant.Constants;
import com.person.rentalcar.constant.SecurityConsts;
import com.person.rentalcar.model.Role;
import com.person.rentalcar.model.User;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.response.RespGenerator;
import com.person.rentalcar.service.RoleService;
import com.person.rentalcar.service.UserService;
import com.person.rentalcar.shiro.security.JwtProperties;
import com.person.rentalcar.shiro.security.JwtToken;
import com.person.rentalcar.shiro.security.JwtUtil;
import com.person.rentalcar.utils.JedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

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

    @Autowired
    private RoleService roleService;


    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private JedisUtils jedisUtils;


    @PostMapping(value = "/manager/login")
    public ApiResponse login(@RequestBody User user, HttpServletResponse response) {
        User u = userService.findByUsername(user.getUsername());
        if (u == null) {
            log.error("用户不存在");
            return RespGenerator.fail("200001", "用户不存在");
        }
        if (!u.getPassword().equals(user.getPassword())) {
            log.error("密码错误");
            return RespGenerator.fail("200002", "密码错误");
        }
        if (u.isUserStatus() == false) {
            log.error("用户被冻结");
            return RespGenerator.fail("200003", "用户被冻结");
        }
        Role role = userService.selectRoleByUserId(u.getUserId());
        if (role == null) {
            log.error("用户角色信息异常");
            userService.changeStatus(u.getUserId(), false);
            return RespGenerator.fail("10000", "用户信息异常，已被冻结");
        }
        if (!"Administrator".equals(role.getRoleIdentity())) {
            log.error("用户权限不足");
            return RespGenerator.fail("200003", "用户权限不足");
        }
        String strToken = this.loginSuccess(u.getUsername(), response);
//        System.out.println("token:" + token);
//        log.info("登录成功");
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new JwtToken(strToken);
        subject.login(token);
        log.info("登录成功");
        return RespGenerator.successful(Constants.TOKEN_CHECK_SUCCESS);

    }

    @PostMapping(value = "/login")
    public ApiResponse clientLogin(@RequestBody User user, HttpServletResponse response) {
        User u = userService.findByUsername(user.getUsername());
        if (u == null) {
            log.error("用户不存在");
            return RespGenerator.fail("200001", "用户不存在");
        }
        if (!u.getPassword().equals(user.getPassword())) {
            log.error("密码错误");
            return RespGenerator.fail("200002", "密码错误");
        }
        if (u.isUserStatus() == false) {
            log.error("用户被冻结");
            return RespGenerator.fail("200003", "用户被冻结");
        }
        String strToken = this.loginSuccess(u.getUsername(), response);
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new JwtToken(strToken);
        subject.login(token);
        log.info("登录成功");
        return RespGenerator.successful(Constants.TOKEN_CHECK_SUCCESS);

    }


    @GetMapping(value = "api/authentication")
    public String authentication() {
        return "身份认证成功";
    }


    /**
     * 登录后更新缓存，生成token，设置响应头部信息
     *
     * @param account
     * @param response
     */
    private String loginSuccess(String account, HttpServletResponse response) {

        String currentTimeMillis = String.valueOf(System.currentTimeMillis());

        //生成token
        JSONObject json = new JSONObject();
        String token = JwtUtil.sign(account, currentTimeMillis);
        json.put("token", token);

        //更新RefreshToken缓存的时间戳
        String refreshTokenKey = SecurityConsts.PREFIX_SHIRO_REFRESH_TOKEN + account;
        jedisUtils.saveString(refreshTokenKey, currentTimeMillis, jwtProperties.getTokenExpireTime() * 60);


        //写入header
        response.setHeader(SecurityConsts.REQUEST_AUTH_HEADER, token);
        response.setHeader("Access-Control-Expose-Headers", SecurityConsts.REQUEST_AUTH_HEADER);

        return token;
    }
}
