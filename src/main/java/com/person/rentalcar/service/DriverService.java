package com.person.rentalcar.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.person.rentalcar.mapper.DrivingBehalfMapper;
import com.person.rentalcar.model.DrivingBehalf;
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
 * @time: 2020/3/1
 */
@Service
public class DriverService {
    @Autowired
    private DrivingBehalfMapper mapper;

    public ApiResponse<PageResult> selectALLDriver(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<DrivingBehalf> driverList = mapper.selectAllDrivingBehalf(request);
        return RespGenerator.successful(PageUtils.getPageResult(new PageInfo<>(driverList)));
    }

    public ApiResponse addDriver(DrivingBehalf driver) {
        boolean b = mapper.addDrivingBehalf(driver);
        if (b) {
            return RespGenerator.successful().setMessage("添加成功");
        } else {
            return RespGenerator.fail("400").setMessage("添加失败，请检查参数");
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

    public ApiResponse updateDriver(DrivingBehalf driver) {
        boolean b = mapper.updateDrivingBehalf(driver);
        if (b) {
            return RespGenerator.successful("更新成功");
        } else {
            return RespGenerator.fail("400").setMessage("更新失败");
        }
    }

    public ApiResponse changeStatus(Integer driverId, boolean status) {
        boolean b = mapper.changeStatus(driverId, status);
        if (b) {
            return RespGenerator.successful("更新状态成功");
        } else {
            return RespGenerator.fail("400").setMessage("更新状态失败");
        }
    }
}
