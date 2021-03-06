package com.person.rentalcar.vo.query;

import lombok.Data;

/**
 * @describtion: 分页
 * @author: yejun
 * @time: 2020/2/18
 */
@Data
public class PageRequest {

    /**
     * 搜索框查询内容
     */
    private String query;

    /**
     * 页码
     */
    private int pageNum;

    /**
     * 页面记录数
     */
    private int pageSize;

}
