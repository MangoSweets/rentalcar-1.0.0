package com.person.rentalcar.mapper;

import com.person.rentalcar.model.Role;

import java.util.List;

public interface RoleMapper {
    boolean addRole(Role role);

    boolean deleteRole(int roleId);

    boolean updateRole(Role role);

    Role selectRole(int roleId);

    List<Role> selectAllRole();

//    List<Role> selectRoleByUserId(int userId);

//    List<Permission> getPermissions(Role role);
}
