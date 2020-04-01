package com.person.rentalcar.mapper;

import com.person.rentalcar.model.Permission;
import com.person.rentalcar.vo.query.PageRequest;

import java.util.List;

public interface PermissionMapper {

    boolean addPermission(Permission permission);

    boolean deletePermission(Integer permissionId);

    boolean updatePermission(Permission permission);

    Permission selectPermissionByPermissionId(Integer permissionId);

    List<Permission> selectAllPermission(PageRequest request);

}
