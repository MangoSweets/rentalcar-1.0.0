package com.person.rentalcar.vo.resp;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/2/12
 */

@Data
@Accessors(chain = true)
public class PageResult {

    private long totalSize;
    private int totalPages;
    private int pageNum;
    private int pageSize;
    private List<?> content;
}
