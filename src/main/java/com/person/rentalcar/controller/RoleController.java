package com.person.rentalcar.controller;

import com.person.rentalcar.model.Role;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.service.RoleService;
import com.person.rentalcar.vo.query.PageRequest;
import com.person.rentalcar.vo.resp.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/4/1
 */
@RestController
public class RoleController {

    @Autowired
    private RoleService service;

    @GetMapping("/role/query")
    public ApiResponse<PageResult> selectAllRole(PageRequest request) {
        return service.selectAllRole(request);
    }

    @PostMapping("/role/add")
    public ApiResponse addRole(@RequestBody Role role) {
        return service.addRole(role);
    }

    @PostMapping("/role/update")
    public ApiResponse updateRole(@RequestBody Role role) {
        return service.updateRole(role);
    }

    @GetMapping("/role/delete")
    public ApiResponse deleteRole(int roleId) {
        return service.deleteRole(roleId);
    }

}
