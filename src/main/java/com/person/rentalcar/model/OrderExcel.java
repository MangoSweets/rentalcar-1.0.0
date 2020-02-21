package com.person.rentalcar.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * 描述:
 * 版本: v1.0.0
 * 日期：2020/1/16 15:57
 * 作者：yejun
 */
@Data
@Builder
public class OrderExcel {

    /**
     * 订单Id
     */
    @Excel(name = "订单ID",width = 20)
    private int orderId;

    /**
     * 用户Id
     */
    @Excel(name = "用户ID",width = 20)
    private int userId;

    /**
     * 汽车Id
     */
    @Excel(name = "汽车ID",width = 20)
    private int carId;

    /**
     * 品牌名
     */
    @Excel(name = "品牌名",width = 20)
    private String brand;

    /**
     * 系列名
     */
    @Excel(name = "系列名",width = 20)
    private String seriesname;

    /**
     * 订单开始时间
     */
    @Excel(name = "订单开始时间",width = 20)
    private Date startTime;

    /**
     * 订单结束时间
     */
    @Excel(name = "订单结束时间",width = 20)
    private Date endTime;

    /**
     * 订单状态
     */
    @Excel(name = "订单状态",width = 20)
    private boolean status;
}
