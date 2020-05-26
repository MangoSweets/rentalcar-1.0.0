package com.person.rentalcar.vo.resp;

import lombok.Data;

/**
 * @describtion: 用户查看自身的代驾订单
 * @author: yejun
 * @time: 2020/5/23
 */
@Data
public class MySharingOrder {
    // 下单的用户的信息
    private String name;
    private String sex;
    private String telephone;

    // 行程信息
    private String price;
    private String path;
    private String time;
    private boolean status;
}
