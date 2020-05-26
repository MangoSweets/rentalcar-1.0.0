package com.person.rentalcar.controller;

import com.person.rentalcar.model.Role;
import com.person.rentalcar.model.User;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.response.RespGenerator;
import com.person.rentalcar.service.UserService;
import com.person.rentalcar.vo.query.PageRequest;
import com.person.rentalcar.vo.resp.PageResult;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/2/8
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    @CrossOrigin
//    @VerifyToken
    @GetMapping(value = "/user/selectall")
    @RequiresAuthentication
    public ApiResponse<PageResult> selectAllUser(PageRequest userQueryVO) {
        System.out.println("111");
        PageResult pageInfo = userService.getPageInfo(userQueryVO);
        return RespGenerator.successful(pageInfo);
    }

    @CrossOrigin
    @PostMapping("/user/addUser")
    @RequiresAuthentication
    public ApiResponse addUser(@RequestBody User user) {
        System.out.println("添加用户");
        System.out.println(user.toString());
        boolean b = userService.addUser(user);
        if (b) {
            return RespGenerator.successful();
        } else {
            return RespGenerator.fail("出错");
        }
    }

    @GetMapping("/user/deleteuser")
    @RequiresAuthentication
    public ApiResponse deleteUser(Integer userId) {
        boolean b = userService.deleteUser(userId);
        if (b) {
            return RespGenerator.successful("删除成功");
        } else {
            return RespGenerator.fail("400").setMessage("删除失败");
        }
    }

    @PostMapping("/user/updateuser")
    @RequiresAuthentication
    public ApiResponse updateUser(@RequestBody User user) {
        boolean b = userService.updateUser(user);
        if (b) {
            return RespGenerator.successful("更新成功");
        } else {
            return RespGenerator.fail("400").setMessage("更新失败");
        }
    }

    @GetMapping("/user/changestatus")
    @RequiresAuthentication
    public ApiResponse changeStatus(Integer userId, boolean status) {
        boolean b = userService.changeStatus(userId, status);
        if (b) {
            return RespGenerator.successful("更新状态成功");
        } else {
            return RespGenerator.fail("400").setMessage("更新状态失败");
        }
    }

    @GetMapping("/user/getlikenames")
    @RequiresAuthentication
    public ApiResponse<List<User>> getLikeUsername(String username) {
        List<User> maps = userService.selectUserByUsername(username);
        if (CollectionUtils.isEmpty(maps)) {
            return RespGenerator.successful(Collections.EMPTY_LIST);
        }
        return RespGenerator.successful(maps);
    }

    @GetMapping("/user/getinformations")
    @RequiresAuthentication
    public ApiResponse<User> getInformations(String username) {
        return userService.getInformations(username);
    }

    @GetMapping("/user/getMyRole")
    @RequiresAuthentication
    public ApiResponse<Role> selecMyRole(int userId){
        return userService.selectMyRole(userId);
    }

    @GetMapping("/user/getRoleInfo")
    @RequiresAuthentication
    public ApiResponse<List<Role>> selectAllRole(){
        return userService.selectAllRole();
    }

    @GetMapping("/user/updateRole")
    @RequiresAuthentication
    public ApiResponse updateRole(int userId,int roleId){
        return userService.updateRole(userId,roleId);
    }
}
