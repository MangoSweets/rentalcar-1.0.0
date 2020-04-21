package com.person.rentalcar.dto;

import lombok.Data;

import java.util.Date;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/2/22
 */
@Data
public class CarDTO {
    /**
     * 汽车ID
     */
    private int carId;

    /**
     * 系列ID
     */
    private int seriesId;

    /**
     * 图片保存路径
     */
    private String imageUrl;

    /**
     * 系列名
     */
    private String seriesName;

    /**
     * 汽车类型(新能源/燃油)
     */
    private String carType;

    /**
     * 车牌号
     */
    private String plateNumber;

    /**
     * 用户评论
     */
    private String userEvaluation;

    /**
     * 价格
     */
    private String price;

    /**
     * 汽车创建时间,默认为当前系统时间
     */
    private Date carCreateTime;

    /**
     * 汽车创建者
     */
    private String carCreater;

    /**
     * 汽车更新时间
     */
    private Date carUpdateTime;

    /**
     * 汽车更新人
     */
    private String carUpdater;

    /**
     * 汽车出厂时间
     */
    private Date productStartTime;

    /**
     * 汽车到期时间
     */
    private Date productEndTime;

    /**
     * 汽车状态
     */
    private boolean carStatus;

}
