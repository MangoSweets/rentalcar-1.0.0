package com.person.rentalcar.mapper.client;

import com.person.rentalcar.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/4/12
 */
public interface ClientUserMapper {

    User getPwdByUsername(String username);

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean modifyPassword(@Param("password") String password,@Param("id") String userId);
}
