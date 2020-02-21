package com.person.rentalcar.utils.pagehelper;

import com.github.pagehelper.PageInfo;
import com.person.rentalcar.vo.resp.PageResult;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/2/18
 */
public class PageUtils {

    public static PageResult getPageResult(PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum())
                  .setPageSize(pageInfo.getPageSize())
                  .setTotalPages(pageInfo.getPages())
                  .setTotalSize(pageInfo.getTotal())
                  .setContent(pageInfo.getList());
        return pageResult;
    }

}
