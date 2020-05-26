package com.person.rentalcar.vo.resp;

import lombok.Data;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/5/14
 */
@Data
public class SharingDriverInfoVO {
    private int drivingBehalfId;
    private String name;
    private String sex;
    private String telephone;
    private String email;
}
