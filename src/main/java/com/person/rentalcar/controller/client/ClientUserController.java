package com.person.rentalcar.controller.client;

import com.person.rentalcar.constant.Constants;
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

import javax.validation.constraints.NotBlank;
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
    public ApiResponse<Integer> getUserIdForUsername(@NotBlank String username) {
        int id=service.getUserIdForUsername(username);
        if (id == 0) {
            return RespGenerator.fail(Constants.PARAM_ERROR.toString());
        }
        return RespGenerator.successful(id);
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

    @PostMapping("/register")
    public ApiResponse usernameIsExited(@RequestBody User user){
        return service.register(user);
    }
}
