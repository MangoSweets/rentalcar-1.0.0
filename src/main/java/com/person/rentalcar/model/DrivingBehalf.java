package com.person.rentalcar.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 描述:
 * 版本: v1.0.0
 * 日期：2020/1/15 14:41
 * 作者：yejun
 */
@Data
@Accessors(chain = true)
public class DrivingBehalf {
    /**
     * 代驾ID
     */
    private int drivingBehalfId;

    /**
     * 聘请该代驾的用户
     */
    private int userId;

    /**
     * 代驾姓名
     */
    private String drivingName;

    /**
     * 代驾性别
     */
    private String drivingSex;

    /**
     * 联系方式
     */
    private String drivingTelephone;

    /**
     * 信誉分
     */
    private String creditscore;

    /**
     * 用户评价
     */
    private String drivingComment;

    /**
     * 代驾驾照
     */
    private String behalfLicense;

    /**
     * 代驾创建者
     */
    private String drivingCreater;

    /**
     * 代驾创建时间
     */
    private Date drivingCreateTime;

    /**
     * 代驾更新者
     */
    private String drivingUpdater;

    /**
     * 代驾更新时间
     */
    private Date drivingUpdateTime;

    /**
     * 代驾状态
     */
    private boolean drivingStatus;

}
