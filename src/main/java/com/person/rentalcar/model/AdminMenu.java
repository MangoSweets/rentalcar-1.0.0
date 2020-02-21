package com.person.rentalcar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/1/20
 */

@Data
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminMenu {
    int id;
    String path;
    String name;
    String nameZh;
    String iconCls;
    String component;
    int parentId;

    // 非数据库字段
    List<AdminMenu> children;
}
