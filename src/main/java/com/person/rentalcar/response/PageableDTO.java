package com.person.rentalcar.response;

import java.io.Serializable;

/**
 * 描述: 分页信息
 * 版本: v1.0.0
 * 日期：2020/1/15 10:50
 * 作者：yejun
 */

public class PageableDTO implements Serializable {

    private static final long serialVersionUID = -3930180379790344299L;

    /**
     * 默认页码.
     */
    private static final int DEFAULT_PAGE_NUMBER = 0;

    /**
     * 默认每页记录数 .
     */
    private static final int DEFAULT_PAGE_SIZE = 20;

    /**
     * 最大每页记录数 .
     */
    private static final int MAX_PAGE_SIZE = 1000;

    /**
     * 页码 .
     */
    private int pageNumber = DEFAULT_PAGE_NUMBER;

    /**
     * 每页记录数 .
     */
    private int pageSize = DEFAULT_PAGE_SIZE;

    // /** 搜索属性. */
    // private String searchProperty;
    //
    // /** 搜索值. */
    // private String searchValue;
    //
    // /** 排序属性 . */
    // private String orderProperty;

    /**
     * 初始化一个新创建的Pageable对象.
     */
    public PageableDTO() {
    }

    /**
     * 初始化一个新创建的Pageable对象.
     *
     * @param pageNumber 页码
     * @param pageSize   每页记录数
     */
    public PageableDTO(Integer pageNumber, Integer pageSize) {
        if (pageNumber != null && pageNumber >= 1) {
            this.pageNumber = pageNumber;
        }
        if (pageSize != null && pageSize >= 1 && pageSize <= MAX_PAGE_SIZE) {
            this.pageSize = pageSize;
        }
    }

    /**
     * 获取页码.
     *
     * @return 页码
     */
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * 设置页码.
     *
     * @param pageNumber 页码
     */
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber < 1 ? DEFAULT_PAGE_NUMBER : pageNumber;
    }

    /**
     * 获取每页记录数.
     *
     * @return 每页记录数
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置每页记录数.
     *
     * @param pageSize 每页记录数
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize < 1 ? DEFAULT_PAGE_SIZE : (pageSize > MAX_PAGE_SIZE ? MAX_PAGE_SIZE : pageSize);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PageableDTO that = (PageableDTO) o;

        if (pageNumber != that.pageNumber) {
            return false;
        }
        return pageSize == that.pageSize;
    }

    @Override
    public int hashCode() {
        int result = pageNumber;
        result = 31 * result + pageSize;
        return result;
    }
}
