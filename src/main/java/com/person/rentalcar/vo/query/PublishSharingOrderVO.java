package com.person.rentalcar.vo.query;

import lombok.Data;

/**
 * @describtion: 发布共享订单
 * @author: yejun
 * @time: 2020/5/13
 */
@Data
public class PublishSharingOrderVO {
    private String path;
    private String time;
    private int price;
    private int drivingbehalfId;
}
