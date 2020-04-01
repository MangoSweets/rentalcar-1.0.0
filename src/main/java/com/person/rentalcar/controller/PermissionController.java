package com.person.rentalcar.controller;

import com.person.rentalcar.model.Permission;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.service.PermissionService;
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
public class PermissionController {

    @Autowired
    private PermissionService service;

    @GetMapping("/permission/query")
    public ApiResponse<PageResult> selectAllpermission(PageRequest request) {
        return service.selectAllPermission(request);
    }

    @PostMapping("/permission/add")
    public ApiResponse addpermission(@RequestBody Permission permission) {
        return service.addPermission(permission);
    }

    @PostMapping("/permission/update")
    public ApiResponse updatepermission(@RequestBody Permission permission) {
        return service.updatePermission(permission);
    }

    @GetMapping("/permission/delete")
    public ApiResponse deletepermission(int permissionId) {
        return service.deletePermission(permissionId);
    }

}
