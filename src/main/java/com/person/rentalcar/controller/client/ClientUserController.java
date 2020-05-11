package com.person.rentalcar.controller.client;

import com.person.rentalcar.model.Order;
import com.person.rentalcar.model.Series;
import com.person.rentalcar.model.User;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.response.RespGenerator;
import com.person.rentalcar.service.client.ClientUserService;
import com.person.rentalcar.vo.query.ClientQueryCarVO;
import com.person.rentalcar.vo.resp.MyOrder;
import com.person.rentalcar.vo.resp.PageResult;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/2/8
 */
@RestController()
@RequestMapping("/client")
public class ClientUserController {

    @Autowired
    private ClientUserService service;

//    @GetMapping(value = "/user/selectall")
//    @RequiresAuthentication
//    public ApiResponse<PageResult> selectAllUser(PageRequest userQueryVO) {
//        PageResult pageInfo = userService.getPageInfo(userQueryVO);
//        return RespGenerator.successful(pageInfo);
//    }

    @PostMapping("/user/addUser")
    @RequiresAuthentication
    public ApiResponse addUser(@RequestBody User user) {
        boolean b = service.addUser(user);
        if (b) {
            return RespGenerator.successful();
        } else {
            return RespGenerator.fail("出错");
        }
    }

//    @GetMapping("/user/deleteuser")
//    @RequiresAuthentication
//    public ApiResponse deleteUser(Integer userId) {
//        boolean b = service.deleteUser(userId);
//        if (b) {
//            return RespGenerator.successful("删除成功");
//        } else {
//            return RespGenerator.fail("400").setMessage("删除失败");
//        }
//    }

    @PostMapping("/user/updateuser")
    @RequiresAuthentication
    public ApiResponse updateUser(@RequestBody User user) {
        boolean b = service.updateUser(user);
        if (b) {
            return RespGenerator.successful("更新成功");
        } else {
            return RespGenerator.fail("400").setMessage("更新失败");
        }
    }

//    @GetMapping("/user/changestatus")
//    @RequiresAuthentication
//    public ApiResponse changeStatus(Integer userId, boolean status) {
//        boolean b = userService.changeStatus(userId, status);
//        if (b) {
//            return RespGenerator.successful("更新状态成功");
//        } else {
//            return RespGenerator.fail("400").setMessage("更新状态失败");
//        }
//    }

//    @GetMapping("/user/getlikenames")
//    @RequiresAuthentication
//    public ApiResponse<List<User>> getLikeUsername(String username) {
//        List<User> maps = userService.selectUserByUsername(username);
//        if (CollectionUtils.isEmpty(maps)) {
//            return RespGenerator.successful(Collections.EMPTY_LIST);
//        }
//        return RespGenerator.successful(maps);
//    }

//    @GetMapping("/user/getinformations")
//    @RequiresAuthentication
//    public ApiResponse<User> getInformations(String username) {
//        return userService.getInformations(username);
//    }

    @GetMapping("/user/queryPwdByUsername")
    @RequiresAuthentication
    public ApiResponse<User> getPwdByUsername(String username) {
        return service.getPwdByUsername(username);
    }

    @GetMapping("/user/modifyPassword")
    @RequiresAuthentication
    public ApiResponse modifyPassword(String userId, String password) {
        return service.modifyPassword(userId, password);
    }

    @PostMapping("/queryCar")
    @RequiresAuthentication
    public ApiResponse<PageResult> queryCar(@RequestBody ClientQueryCarVO vo) {
        return RespGenerator.successful(service.queryCar(vo));
    }

    @GetMapping("/getUserId")
    @RequiresAuthentication
    public ApiResponse<Integer> getUserIdForUsername(String username) {
        return service.getUserIdForUsername(username);
    }

    @GetMapping("/getOrderInfoForUser")
    @RequiresAuthentication
    public ApiResponse<User> getUserInfoForOrder(int userId) {
        return service.getUserInfoForOrder(userId);
    }

    @GetMapping("/getSeriesInfoForCarId")
    @RequiresAuthentication
    public ApiResponse<Series> getSeriesInfoForCarId(int carId) {
        return service.getSeriesInfoForCarId(carId);
    }

    @PostMapping("/addOrder")
    @RequiresAuthentication
    public ApiResponse getOrder(@RequestBody Order order) {
        return service.addOrder(order);
    }

    @GetMapping("/selectOrderForUserId")
    @RequiresAuthentication
    public ApiResponse<List<MyOrder>> selectOrderForUserId(int userId) {
        return service.selectMyOrderForUserId(userId);
    }
}
