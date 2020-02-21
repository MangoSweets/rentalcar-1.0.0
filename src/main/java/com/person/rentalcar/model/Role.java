package com.person.rentalcar.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
     * 角色url
     */
    private String roleUrl;

    private String permissions;
    /**
     * 角色创建时间
     */
    private Date roleCreateTime;

    /**
     * 角色创建人
     */
    private String roleCreater;

    /**
     * 角色更新时间
     */
    private Date roleUpdateTime;

    /**
     * 角色更新人
     */
    private String roleUpdater;

    /**
     * 角色状态
     */
    private boolean roleStatus ;
}
