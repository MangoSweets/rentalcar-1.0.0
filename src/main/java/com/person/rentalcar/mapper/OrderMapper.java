package com.person.rentalcar.mapper;

import com.person.rentalcar.model.Order;
import com.person.rentalcar.vo.query.PageRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    boolean addOrder(Order order);

    boolean updateOrder(Order order);

    boolean changeStatus(@Param("orderId") int orderId,@Param("status") boolean status);

    Order selectOrderByOrderId(int orderId);

    List<Order> selectAllOrder(PageRequest request);

    boolean deleteOrder(int orderId);
}
