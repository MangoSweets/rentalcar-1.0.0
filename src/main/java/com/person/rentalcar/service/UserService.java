package com.person.rentalcar.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.person.rentalcar.mapper.UserMapper;
import com.person.rentalcar.model.Role;
import com.person.rentalcar.model.User;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.response.RespGenerator;
import com.person.rentalcar.utils.pagehelper.PageUtils;
import com.person.rentalcar.vo.query.PageRequest;
import com.person.rentalcar.vo.resp.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


//    public ApiResponse login(User user) {
//        if (!userMapper.isExistUserByUsername(user.getUsername())) {
//            return RespGenerator.fail(RespcodeEnum.FAILD.getCode(), "用户名不存在");
//        }
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());
//        usernamePasswordToken.setRememberMe(true);
//        try {
//            subject.login(usernamePasswordToken);
//            return RespGenerator.successful(usernamePasswordToken);
//        } catch (AuthenticationException e) {
//            return RespGenerator.fail(RespcodeEnum.FAILD.getCode(), "密码错误");
//        }
//
//    }

//    public ApiResponse<String> register(User user) {
//        user.setUsername(HtmlUtils.htmlEscape(user.getUsername()));
//        if (userMapper.isExistUserByUsername(user.getUsername()))
//            return RespGenerator.fail("该用户名已存在");
//        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
//        int times = 2;
//        String encodedPassword = new SimpleHash("md5", user.getPassword(), salt, times).toString();
//        user.setSalt(salt).setPassword(encodedPassword);
//        userMapper.addUser(user);
//        return RespGenerator.successful(RespcodeEnum.SUCCESS.getCode());
//    }

    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    public List<User> selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

    public boolean deleteUser(Integer userId) {
        return userMapper.deleteUser(userId);
    }

    public PageResult getPageInfo(PageRequest vo) {
        int pageNum = vo.getPageNum();
        int pageSize = vo.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.selectAllUser(vo);
        return PageUtils.getPageResult(new PageInfo<>(userList));
    }

    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public boolean changeStatus(Integer userId, boolean status) {
        return userMapper.updateUserStatus(userId, status);
    }

    public ApiResponse<User> getInformations(String username) {
        User information = userMapper.getInformation(username);
        if (information == null) {
            return RespGenerator.fail("500");
        }
        return RespGenerator.successful(information);
    }

    public Role selectRoleByUserId(int userId) {
        return userMapper.selectRoleByUserId(userId);
    }

    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    public User findByUserId(int userId) {
        return userMapper.findByUserId(userId);
    }


}
