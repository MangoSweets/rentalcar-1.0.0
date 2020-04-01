package com.person.rentalcar.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.person.rentalcar.mapper.PermissionMapper;
import com.person.rentalcar.model.Permission;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.response.RespGenerator;
import com.person.rentalcar.utils.pagehelper.PageUtils;
import com.person.rentalcar.vo.query.PageRequest;
import com.person.rentalcar.vo.resp.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/4/1
 */
@Service
@Slf4j
public class PermissionService {

    @Autowired
    private PermissionMapper mapper;

    public ApiResponse addPermission(Permission permission) {
        boolean b = mapper.addPermission(permission);
        if (b) {
            log.info("新增权限");
            return RespGenerator.successful();
        }
        return RespGenerator.fail("500").setMessage("添加权限失败");
    }

    public ApiResponse<PageResult> selectAllPermission(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Permission> permissions = mapper.selectAllPermission(request);
        log.info("查询所有权限");
        return RespGenerator.successful(PageUtils.getPageResult(new PageInfo<>(permissions)));
    }

    public ApiResponse updatePermission(Permission permission) {
        boolean b = mapper.updatePermission(permission);
        if (b) {
            log.info("修改权限");
            return RespGenerator.successful();
        }
        return RespGenerator.fail("500").setMessage("修改权限失败");
    }

    public ApiResponse deletePermission(int permissionId) {
        boolean b = mapper.deletePermission(permissionId);
        if (b) {
            log.info("删除权限");
            return RespGenerator.successful();
        }
        return RespGenerator.fail("500").setMessage("删除权限失败");
    }

}
