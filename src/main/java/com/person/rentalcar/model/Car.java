package com.person.rentalcar.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 描述:
 * 版本: v1.0.0
 * 日期：2020/1/15 14:38
 * 作者：yejun
 */

@Data
@Accessors(chain = true)
public class Car {
    /**
     * 汽车ID
     */
    private int carId;

    /**
     * 系列ID
     */
    private int seriesId;

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
    private boolean carStatus ;
}
