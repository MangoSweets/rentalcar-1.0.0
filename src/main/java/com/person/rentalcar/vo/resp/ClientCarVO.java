package com.person.rentalcar.vo.resp;

import lombok.Data;

/**
 * @describtion: 客户端展示满足条件的表单VO
 * @author: yejun
 * @time: 2020/4/27
 */
@Data
public class ClientCarVO {

    private int carId;

    /**
     * 图片
     */
    private String imageUrl;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 系列名
     */
    private String seriesname;

    /**
     * 价格
     */
    private String price;
}
