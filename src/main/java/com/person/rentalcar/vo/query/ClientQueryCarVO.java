package com.person.rentalcar.vo.query;

import lombok.Data;

/**
 * @describtion: 客户端查询符合条件的汽车
 * @author: yejun
 * @time: 2020/4/27
 */
@Data
public class ClientQueryCarVO {

    /**
     * 汽车价格
     */
    private int price;

    /**
     * 汽车品牌
     */
    private String brand;

    /**
     * 取车时间
     */
    private String getTime ;

    /**
     * 还车时间
     */
    private String backTime;

    /**
     * 页码
     */
    private int pageNum;

    /**
     * 页面记录数
     */
    private int pageSize;
}
