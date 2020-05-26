package com.person.rentalcar.model;

import lombok.Data;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/5/12
 */
@Data
public class SharingOrder {
    private int sharingoderId;
    private String name;
    private String sex;
    private String telephone;
    private String path;
    private String price;
    private String time;
    private boolean status;
}
