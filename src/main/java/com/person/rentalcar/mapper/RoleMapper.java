package com.person.rentalcar.mapper;

import com.person.rentalcar.model.Permission;
import com.person.rentalcar.model.Role;
import com.person.rentalcar.vo.query.PageRequest;

import java.util.List;

public interface RoleMapper {
    boolean addRole(Role role);

    boolean deleteRole(int roleId);

    boolean updateRole(Role role);

    Role selectRole(int roleId);

    List<Role> selectAllRole(PageRequest request);

    List<Permission> selectPermissionByRole(int roleId);
}
