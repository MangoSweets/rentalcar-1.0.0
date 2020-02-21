package com.person.rentalcar.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 版本: v1.0.0
 * 日期：2020/1/15 10:50
 * 作者：yejun
 */
public class PageDTO<T> implements Serializable {

    private static final long serialVersionUID = -2053800594583879853L;

    /**
     * 内容.
     */
    private final List<T> content = new ArrayList<T>();

    /**
     * 总记录数.
     */
    private final long total;

    private final long pageSize;

    /**
     * 初始化一个新创建的Page对象.
     */
    public PageDTO() {
        this.total = 0L;
        this.pageSize = 1L;
    }

    /**
     * @param content 内容
     * @param total   总记录数
     */
    public PageDTO(List<T> content, long total, long pageSize) {
        this.content.addAll(content);
        this.total = total;
        this.pageSize = pageSize;
    }

    /**
     * @see PageDTO
     */
    @Deprecated
    public PageDTO(List<T> content, long total, PageableDTO pageable) {
        this.content.addAll(content);
        this.total = total;
        this.pageSize = pageable.getPageSize();
    }

    /**
     * 获取内容.
     *
     * @return 内容
     */
    public List<T> getContent() {
        return content;
    }

    /**
     * 获取总记录数.
     *
     * @return 总记录数
     */
    public Long getTotal() {
        return total;
    }

    public Long getPageSize() {
        return pageSize;
    }

}
