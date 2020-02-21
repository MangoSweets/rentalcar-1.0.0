package com.person.rentalcar.mapper;

import com.person.rentalcar.model.Order;

import java.util.List;

public interface OrderMapper {

    boolean addOrder(Order order);

    boolean updateOrder(Order order);

    boolean deleteOrder(int orderId);

    Order selectOrderByOrderId(int orderId);

    List<Order> selectAllOrder();
}
