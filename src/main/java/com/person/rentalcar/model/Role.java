package com.person.rentalcar.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 描述: 角色
 * 版本: v1.0.0
 * 日期：2020/1/14 12:51
 * 作者：yejun
 */
@Data
@Accessors(chain = true)
public class Role {
    /**
     * 角色ID
     */
    private int roleId;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色标识
     */
    private String roleIdentity;
}
