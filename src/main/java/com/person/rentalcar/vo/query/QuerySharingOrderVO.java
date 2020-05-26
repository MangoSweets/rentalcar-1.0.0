package com.person.rentalcar.vo.query;

import lombok.Data;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/5/12
 */
@Data
public class QuerySharingOrderVO {

    private int price;

    private String time;

    private String path;

    /**
     * 页码
     */
    private int pageNum;

    /**
     * 页面记录数
     */
    private int pageSize;
}
