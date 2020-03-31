package com.person.rentalcar.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 描述: 用户
 * 版本: v1.0.0
 * 日期：2020/1/14 12:40
 * 作者：yejun
 */
@Data
@Accessors(chain = true)
public class User {
    /**
     * 用户ID
     */
    private int userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 加盐
     */
    private String salt;
    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 手机号码
     */
    private String telephone;

    /**
     * 证件类型(10:身份证，11:台湾居民来往大陆身份证，12:港澳来陆身份证，13:外籍护照)
     */
    private String cardTypeSelect;


    /**
     * 证件号码
     */
    private String IDCard;

    /**
     * 银行卡
     */
    private String bankCard;

    /**
     * 驾照
     */
    private String drivingLicense;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 区县
     */
    private String region;

    /**
     * 用户常驻地址
     */
    private String address;

    /**
     * 紧急联系人
     */
    private String errorTipLinkman;

    /**
     * 紧急联系电话
     */
    private String linkManTele;

    /**
     * 角色
     */
    private String roles;

    /**
     * 代驾ID
     */
    private int drivingBehalfID;

    /**
     * 用户创建时间,默认为当前系统时间
     */
    private Date userCreateTime;

    /**
     * 用户创建者
     */
    private String userCreater;

    /**
     * 用户更新时间
     */
    private Date userUpdateTime;

    /**
     * 用户更新人
     */
    private String userUpdater;

    /**
     * 用户状态
     */
    private boolean userStatus;
}
