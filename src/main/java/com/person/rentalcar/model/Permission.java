package com.person.rentalcar.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 描述: 权限
 * 版本: v1.0.0
 * 日期：2020/1/14 12:52
 * 作者：yejun
 */
@Data
@Accessors(chain = true)
public class Permission {
    /**
     * 权限ID
     */
    private int permissionId;

    /**
     * 权限名
     */
    private String permissionName;

    /**
     * 权限url
     */
    private String permissionUrl;

    /**
     * 权限创建时间
     */
    private Date permissionCreatTime;

    /**
     * 权限创建者
     */
    private String permissionCreater;

    /**
     * 权限更新时间
     */
    private Date permissionUpdateTime;

    /**
     * 权限更新人
     */
    private String permissionUpdater;

    /**
     * 权限状态
     */
    private boolean permissionStatus;
}
