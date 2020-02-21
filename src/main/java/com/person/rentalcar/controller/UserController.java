package com.person.rentalcar.controller;

import com.person.rentalcar.model.User;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.response.RespGenerator;
import com.person.rentalcar.service.UserService;
import com.person.rentalcar.vo.query.UserQueryVO;
import com.person.rentalcar.vo.resp.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/2/8
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @GetMapping(value = "/user/selectall")
    public ApiResponse<PageResult> selectAllUser(UserQueryVO userQueryVO) {
        System.out.println("111");
        PageResult pageInfo = userService.getPageInfo(userQueryVO);
        return RespGenerator.successful(pageInfo);
    }

    @CrossOrigin
    @PostMapping("/user/addUser")
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
    public ApiResponse deleteUser(Integer userId) {
        boolean b = userService.deleteUser(userId);
        if (b) {
            return RespGenerator.successful("删除成功");
        } else {
            return RespGenerator.fail("400").setMessage("删除失败");
        }
    }

    @PostMapping("/user/updateuser")
    public ApiResponse updateUser(@RequestBody User user){
        boolean b = userService.updateUser(user);
        if (b) {
            return RespGenerator.successful("更新成功");
        } else {
            return RespGenerator.fail("400").setMessage("更新失败");
        }
    }

    @GetMapping("/user/changestatus")
    public ApiResponse changeStatus(Integer userId,boolean status){
        boolean b = userService.changeStatus(userId, status);
        if (b) {
            return RespGenerator.successful("更新状态成功");
        } else {
            return RespGenerator.fail("400").setMessage("更新状态失败");
        }
    }
}
