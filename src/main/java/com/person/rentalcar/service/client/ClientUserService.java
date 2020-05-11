package com.person.rentalcar.service.client;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.person.rentalcar.constant.Constants;
import com.person.rentalcar.mapper.client.ClientUserMapper;
import com.person.rentalcar.model.Order;
import com.person.rentalcar.model.Series;
import com.person.rentalcar.model.User;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.response.RespGenerator;
import com.person.rentalcar.utils.pagehelper.PageUtils;
import com.person.rentalcar.vo.query.ClientQueryCarVO;
import com.person.rentalcar.vo.resp.ClientCarVO;
import com.person.rentalcar.vo.resp.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        log.info("执行{}中的{}方法", "ClientUserService", "getPwdByUsername");
        User user = mapper.getPwdByUsername(username);
        if (user == null) {
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

    public ApiResponse modifyPassword(String userId, String password) {
        log.info("执行{}中的{}方法", "ClientUserService", "modifyPassword");
        boolean b = mapper.modifyPassword(password, userId);
        if (b) {
            log.info("用户成功修改密码");
            return RespGenerator.successful();
        }
        return RespGenerator.fail("50002", "用户信息异常");
    }

    public PageResult queryCar(ClientQueryCarVO request) {
        if (StringUtils.isEmpty(request.getGetTime())) {
            request.setGetTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }
        if (StringUtils.isEmpty(request.getBackTime())) {
            request.setBackTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }
        int pageNum = request.getPageNum();
        int pageSize = request.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<ClientCarVO> carList = mapper.selectCarInformationForClient(request);
        return PageUtils.getPageResult(new PageInfo<>(carList));
    }

    public ApiResponse<Integer> getUserIdForUsername(@NotBlank String username) {
        int id = mapper.getUserIdForUsername(username);
        if (id == 0) {
            log.error("{}该用户名信息错误，请检查", username);
            return RespGenerator.fail(Constants.PARAM_ERROR.toString());
        }
        return RespGenerator.successful(id);
    }

    public ApiResponse<User> getUserInfoForOrder(int userId) {
        User user = mapper.getUserInfoForOrder(userId);
        if (user == null) {
            log.error("{}该用户Id信息错误，请检查", userId);
            return RespGenerator.fail(Constants.PARAM_ERROR.toString());
        }
        return RespGenerator.successful(user);
    }

    public ApiResponse<Series> getSeriesInfoForCarId(int carId) {
        Series seriesInfoForCarId = mapper.getSeriesInfoForCarId(carId);
        if (seriesInfoForCarId == null) {
            log.error("汽车ID错误");
            return RespGenerator.fail(Constants.PARAM_ERROR.toString());
        }
        return RespGenerator.successful(seriesInfoForCarId);
    }

    public ApiResponse addOrder(Order order) {
        boolean b = mapper.addOrder(order);
        if (b) {
            return RespGenerator.successful();
        }
        return RespGenerator.fail(Constants.PARAM_ERROR.toString());
    }
}
