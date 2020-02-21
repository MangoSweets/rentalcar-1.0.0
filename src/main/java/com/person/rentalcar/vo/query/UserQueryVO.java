package com.person.rentalcar.vo.query;

import lombok.Data;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/2/12
 */

@Data
public class UserQueryVO extends PageRequest{

    /**
     * 查询内容
     */
    private String query;
}
