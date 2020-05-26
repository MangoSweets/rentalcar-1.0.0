package com.person.rentalcar.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.person.rentalcar.constant.Constants;
import com.person.rentalcar.mapper.DrivingBehalfMapper;
import com.person.rentalcar.mapper.UserMapper;
import com.person.rentalcar.model.User;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.response.RespGenerator;
import com.person.rentalcar.utils.pagehelper.PageUtils;
import com.person.rentalcar.vo.query.PageRequest;
import com.person.rentalcar.vo.resp.PageResult;
import com.person.rentalcar.vo.resp.SharingDriverInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/3/1
 */
@Service
public class DriverService {
    @Autowired
    private DrivingBehalfMapper mapper;

    @Autowired
    private UserMapper userMapper;

    public ApiResponse<PageResult> selectALLDriver(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<SharingDriverInfoVO> driverList = mapper.selectAllDrivingBehalf(request);
        return RespGenerator.successful(PageUtils.getPageResult(new PageInfo<>(driverList)));
    }

    public ApiResponse addDriver(String username) {
        User user = userMapper.findByUsername(username);
        if (user == null) {
            return RespGenerator.fail(Constants.PARAM_ERROR.toString(), "用户名不存在");
        }
        boolean have = mapper.IsDrivingBehalf(username);
        if (have == true) {
            return RespGenerator.fail(Constants.PARAM_ERROR.toString(), "该用户已经是代驾，不能添加");
        }
        boolean b = mapper.addDrivingBehalf(user.getUserId());
        if (b) {
            return RespGenerator.successful().setMessage("添加成功");
        } else {
            return RespGenerator.fail("50000","系统异常，请联系管理员");
        }
    }

    public ApiResponse deleteDriver(Integer drivingBehalfId) {
        boolean b = mapper.deleteDrivingBehalf(drivingBehalfId);
        if (b) {
            return RespGenerator.successful("删除成功");
        } else {
            return RespGenerator.fail("400").setMessage("删除失败");
        }
    }



}
