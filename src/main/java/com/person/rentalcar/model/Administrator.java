package com.person.rentalcar.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 描述: 管理员
 * 版本: v1.0.0
 * 日期：2020/1/14 12:57
 * 作者：yejun
 */
@Data
@Accessors(chain = true)
public class Administrator {


    /**
     * 管理员Id
     */
    private int administratorId;

    /**
     * 用户名
     */
    private String admin;

    /**
     * 密码
     */
    private String password;

    /**
     * 管理员创建者
     */
    private String adminCreater;

    /**
     * 管理员创建时间
     */
    private Date adminCreateTime;

    /**
     * 管理员更新者
     */
    private String adminUpdater;

    /**
     * 管理员更新时间
     */
    private Date adminUpdateTime;

    /**
     * 管理员状态
     */
    private boolean adminStatus;
}
