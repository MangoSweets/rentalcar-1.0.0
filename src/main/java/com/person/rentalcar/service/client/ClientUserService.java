package com.person.rentalcar.service.client;

import com.person.rentalcar.mapper.client.ClientUserMapper;
import com.person.rentalcar.model.User;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.response.RespGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/4/12
 */
@Service
@Slf4j
public class ClientUserService {

    @Autowired
    private ClientUserMapper mapper;

    public ApiResponse getPwdByUsername(String username) {
        log.info("执行{}中的{}方法","ClientUserService","getPwdByUsername");
        User user = mapper.getPwdByUsername(username);
        if (user ==null) {
            log.error("获取用户信息异常");
            return RespGenerator.fail("50002").setMessage("用户信息异常");
        }
        log.info("成功获取用户信息");
        return RespGenerator.successful(user);
    }

    public boolean addUser(User user) {
        return mapper.addUser(user);
    }

    public boolean updateUser(User user) {
        return mapper.updateUser(user);
    }

    public ApiResponse modifyPassword(String userId, String password){
        log.info("执行{}中的{}方法","ClientUserService","modifyPassword");
        boolean b = mapper.modifyPassword(password, userId);
        if(b){
            log.info("用户成功修改密码");
            return RespGenerator.successful();
        }
        return RespGenerator.fail("50002","用户信息异常");
    }
}
