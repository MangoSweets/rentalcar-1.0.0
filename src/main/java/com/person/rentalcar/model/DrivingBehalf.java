package com.person.rentalcar.model;

import lombok.Data;
import lombok.experimental.Accessors;

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


    private int userId;

}
