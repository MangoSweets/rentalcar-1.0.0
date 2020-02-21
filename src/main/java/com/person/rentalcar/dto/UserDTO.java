package com.person.rentalcar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/2/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserDTO {
    private int totalSize;
    private int totalPages;
    private int pageNum;
    private int pageSize;
    private List<?> userList;
}
