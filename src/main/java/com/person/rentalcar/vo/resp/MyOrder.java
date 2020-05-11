package com.person.rentalcar.vo.resp;

import lombok.Data;

/**
 * @describtion: 客户端查看自己订单
 * @author: yejun
 * @time: 2020/5/11
 */
@Data
public class MyOrder {
    private String brand;
    private String seriesname;
    private String startTime;
    private String endTime;
    private String userId;
    private String carId;
    private boolean status;
}
