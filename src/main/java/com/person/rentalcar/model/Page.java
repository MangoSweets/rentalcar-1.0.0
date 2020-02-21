package com.person.rentalcar.model;

import lombok.Data;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/2/12
 */
@Data
public class Page {
    /**
     * 页码
     */
    private String pageNum;

    /**
     * 页面条数
     */
    private String pageSize;
}
