package com.person.rentalcar.mapper;

import com.person.rentalcar.model.User;
import com.person.rentalcar.vo.query.PageRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean updateUserStatus(@Param("userId") Integer userId,@Param("status") boolean status);

    List<User> selectUserByUsername(String username);

    boolean isExistUserByUsername(String username);

    String getRoles(User user);

    boolean deleteUser(Integer userId);

    //----------------------管理员-----------------------

    boolean updateRoleForUser(User user);

    List<User> selectAllUser(PageRequest userQueryVO);

}
