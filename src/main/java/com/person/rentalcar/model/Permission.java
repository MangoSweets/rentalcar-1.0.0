package com.person.rentalcar.model;

import lombok.Data;
import lombok.experimental.Accessors;

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
     * 权限码
     */
    private String permissionCode;

    /**
     * 权限url
     */
    private String permissionUrl;

}
