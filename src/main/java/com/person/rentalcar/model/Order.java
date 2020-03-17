package com.person.rentalcar.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 描述: 订单
 * 版本: v1.0.0
 * 日期：2020/1/15 14:41
 * 作者：yejun
 */
@Data
@Accessors(chain = true)
public class Order {

    /**
     * 订单Id
     */
    private int orderId;

    /**
     * 用户Id
     */
    private int userId;

    private String username;

    /**
     * 汽车Id
     */
    private int carId;

    /**
     * 价格
     */
    private String price;

    private String seriesName;

    /**
     * 订单开始时间
     */
    private Date startTime;

    /**
     * 订单结束时间
     */
    private Date endTime;

    /**
     * 订单状态
     */
    private boolean status;
}
