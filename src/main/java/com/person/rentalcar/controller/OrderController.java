package com.person.rentalcar.controller;

import com.person.rentalcar.model.Order;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.service.OrderService;
import com.person.rentalcar.vo.query.PageRequest;
import com.person.rentalcar.vo.resp.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/3/4
 */

@RestController
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/order/query")
    public ApiResponse<PageResult> selectAllOrder(PageRequest request){
        return service.selectAllOrder(request);
    }

    @GetMapping("/order/changestatus")
    public ApiResponse changeStatus(int orderId,boolean status){
        return service.changeStatus(orderId,status);
    }

    @GetMapping("/order/delete")
    public ApiResponse deleteOder(int orderId){
        return service.deleteOrder(orderId);
    }

    @PostMapping("/order/update")
    public ApiResponse updateOrder(@RequestBody Order order){
        return service.updateOrder(order);
    }

    @PostMapping("/order/add")
    public ApiResponse addOrder(@RequestBody Order order){
        return service.addOrder(order);
    }
}
