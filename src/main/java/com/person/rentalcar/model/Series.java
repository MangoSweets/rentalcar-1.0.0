package com.person.rentalcar.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 描述:
 * 版本: v1.0.0
 * 日期：2020/1/15 14:43
 * 作者：yejun
 */
@Data
@Accessors(chain = true)
public class Series {

    private int seriesId;

    /**
     * 品牌名
     */
    private String brand;

    /**
     * 系列名
     */
    private String seriesName;

    /**
     * 车门数
     */
    private int doors;

    /**
     * 天窗
     */
    private boolean skylight;

    /**
     * 气囊数
     */
    private int airsac;

    /**
     * 座位类型
     */
    private String seatType;

    /**
     * 油箱容量
     */
    private int fuelTank;

    /**
     * 座位数
     */
    private int seatNumber;

    /**
     * 燃料类型
     */
    private String fuelType;

    /**
     * 倒车雷达
     */
    private boolean radar;

    /**
     * 燃油标号
     */
    private String fulelabel;

    /**
     * 发动机进气形式
     */
//    private String engineIntakeType;


    /**
     * 驱动方式
     */
    private String drivingMode;

    /**
     * 变速箱类型(手动挡，自动挡)
     */
    private String transmissionType;

    /**
     * 排量
     */
    private String displacement;

//    private boolean DVD;
//
//    private boolean GPS;

    /**
     * 音箱个数
     */
    private int voiceboxs;

    private String seriesCreater ;

    private Date seriesCreateTime;

    private String seriesUpdater;

    private Date seriesUpdateTime;

    private boolean seriesStatus ;
}
