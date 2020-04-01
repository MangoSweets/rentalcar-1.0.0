package com.person.rentalcar.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.person.rentalcar.mapper.RoleMapper;
import com.person.rentalcar.model.Role;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.response.RespGenerator;
import com.person.rentalcar.utils.pagehelper.PageUtils;
import com.person.rentalcar.vo.query.PageRequest;
import com.person.rentalcar.vo.resp.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/4/1
 */
@Service
public class RoleService {

    @Autowired
    private RoleMapper mapper;

    public ApiResponse<PageResult> selectAllRole(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Role> roles = mapper.selectAllRole(request);
        return RespGenerator.successful(PageUtils.getPageResult(new PageInfo<>(roles)));
    }

    public ApiResponse addRole(Role role) {
        boolean b = mapper.addRole(role);
        if (b) {
            return RespGenerator.successful();
        }
        return RespGenerator.fail("500").setMessage("参数有误,请检查参数");
    }

    public ApiResponse updateRole(Role role) {
        boolean b = mapper.updateRole(role);
        if (b) {
            return RespGenerator.successful();
        }
        return RespGenerator.fail("500").setMessage("参数有误");
    }

    public ApiResponse deleteRole(int roleId) {
        boolean b = mapper.deleteRole(roleId);
        if (b) {
            return RespGenerator.successful().setMessage("删除成功");
        }
        return RespGenerator.fail("500").setMessage("参数有误");
    }
}
