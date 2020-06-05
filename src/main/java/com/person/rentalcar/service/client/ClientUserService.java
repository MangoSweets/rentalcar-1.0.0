package com.person.rentalcar.service.client;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.person.rentalcar.constant.Constants;
import com.person.rentalcar.mapper.client.ClientUserMapper;
import com.person.rentalcar.model.*;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.response.RespGenerator;
import com.person.rentalcar.utils.pagehelper.PageUtils;
import com.person.rentalcar.vo.query.ClientQueryCarVO;
import com.person.rentalcar.vo.query.PublishSharingOrderVO;
import com.person.rentalcar.vo.query.QuerySharingOrderVO;
import com.person.rentalcar.vo.resp.ClientCarVO;
import com.person.rentalcar.vo.resp.MyOrder;
import com.person.rentalcar.vo.resp.MySharingOrder;
import com.person.rentalcar.vo.resp.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    public Integer getUserIdForUsername(String username) {
        return mapper.getUserIdForUsername(username);
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
        order.setStatus(true);
        boolean b = mapper.addOrder(order);
        if (b) {
            return RespGenerator.successful();
        }
        return RespGenerator.fail(Constants.PARAM_ERROR.toString());
    }

    public ApiResponse<List<MyOrder>> selectMyOrderForUserId(int userId) {
        List<MyOrder> orderList = mapper.selectMyOrderForUserId(userId);
        return RespGenerator.successful(orderList);
    }

    public boolean setRole(int userId, int roleId) {
        return mapper.setRole(userId, roleId);
    }

    public ApiResponse register(User user) {
        Integer id = getUserIdForUsername(user.getUsername());
        if (id != null) {
            return RespGenerator.successful("EXIT");
        }
//        User u = mapper.usernameIsExited(user.getUsername());
        boolean b = addUser(user);
        if (b) {
            Integer nid = getUserIdForUsername(user.getUsername());
            setRole(nid, 3);
        }
        return RespGenerator.successful("SUCCESS");
    }

    public PageResult selectSharingOrder(QuerySharingOrderVO vo) {
        int pageNum = vo.getPageNum();
        int pageSize = vo.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<SharingOrder> sharingOrders = mapper.selectSharingOrder(vo);
        return PageUtils.getPageResult(new PageInfo<>(sharingOrders));
    }

    public ApiResponse becomeDriveSharing(int userId) {
        boolean b = mapper.becomeDriveSharing(userId);
        if (b) {
            return RespGenerator.successful();
        } else {
            return RespGenerator.fail(Constants.PARAM_ERROR.toString());
        }
    }

    public ApiResponse<User> getUserInfoForUsername(String username) {
        User user = mapper.getUserForUsername(username);
        if (user == null) {
            return RespGenerator.fail(Constants.PARAM_ERROR.toString());
        }
        return RespGenerator.successful(user);
    }

    public ApiResponse<Boolean> driveSharingExit(int userId) {
        List<DrivingBehalf> drivingBehalves = mapper.driveSharingExit(userId);
        if (CollectionUtils.isEmpty(drivingBehalves)) {
            return RespGenerator.successful(false);
        } else {
            return RespGenerator.successful(true);
        }
    }

    public ApiResponse publishSharingOrderVO(PublishSharingOrderVO vo) throws ParseException {
        String time = vo.getTime();
        time = time.replace("Z", " UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        Date date = df.parse(time);
        SimpleDateFormat df1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
        Date date1 = df1.parse(date.toString());
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newTime = df2.format(date1);
        vo.setTime(newTime);
        boolean b = mapper.publishSharingOrderVO(vo);
        if (b) {
            return RespGenerator.successful();
        } else {
            return RespGenerator.fail("50000", "系统出错,发布失败");
        }
    }

    public ApiResponse<Integer> getDrivingBehalfId(int userId) {
        Integer i = mapper.getDrivingBehalfId(userId);
        if (i == null) {
            return RespGenerator.fail(Constants.PARAM_ERROR.toString());
        }
        return RespGenerator.successful(i);
    }

    public ApiResponse orderSharingDriver(int sharingoderId, int userId) {
        Integer drivingBehalfId = mapper.getDrivingBehalfId(userId);
        boolean b = mapper.orderSharingDriver(sharingoderId, userId);
        if (b) {
            return RespGenerator.successful();
        }
        return RespGenerator.fail(Constants.PARAM_ERROR.toString());
    }

    public ApiResponse<List<MySharingOrder>> selectMySharingOrder(int drivingBehalfId) {
        List<MySharingOrder> mySharingOrders = mapper.selectMySharingOrder(drivingBehalfId);
        return RespGenerator.successful(mySharingOrders);
    }
}
