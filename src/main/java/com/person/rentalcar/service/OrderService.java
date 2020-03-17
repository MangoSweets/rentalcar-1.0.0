package com.person.rentalcar.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.person.rentalcar.mapper.OrderMapper;
import com.person.rentalcar.model.Order;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.response.RespGenerator;
import com.person.rentalcar.utils.pagehelper.PageUtils;
import com.person.rentalcar.vo.query.PageRequest;
import com.person.rentalcar.vo.resp.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/3/4
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper mapper;

    public ApiResponse<PageResult> selectAllOrder(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Order> orders = mapper.selectAllOrder(request);
        return RespGenerator.successful(PageUtils.getPageResult(new PageInfo<>(orders)));
    }

    public ApiResponse changeStatus(int orderId, boolean status) {
        return RespGenerator.successful(mapper.changeStatus(orderId, status));
    }


    public ApiResponse deleteOrder(int orderId) {
        return RespGenerator.successful(mapper.deleteOrder(orderId));
    }

    public ApiResponse updateOrder(Order order) {
        return RespGenerator.successful(mapper.updateOrder(order));
    }

    public ApiResponse addOrder(Order order) {
        boolean b = mapper.addOrder(order);
        if(b){
            return RespGenerator.successful().setMessage("新加订单成功");
        }
        else{
            return RespGenerator.fail("400").setMessage("订单新加失败，请检查从参数");
        }
    }
}
