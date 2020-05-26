package com.person.rentalcar.mapper;

import com.person.rentalcar.model.DrivingBehalf;
import com.person.rentalcar.vo.query.PageRequest;
import com.person.rentalcar.vo.resp.SharingDriverInfoVO;

import java.util.List;

/**
 * 描述:
 * 版本: v1.0.0
 * 日期：2020/1/15 14:44
 * 作者：yejun
 */
public interface DrivingBehalfMapper {

    boolean addDrivingBehalf(int userId);

    boolean IsDrivingBehalf(String username);

    boolean deleteDrivingBehalf(int drivingBehalfId);

    DrivingBehalf selectDrivingBehalfByDrivingBehalfId(int drivingBehalfId);

    List<SharingDriverInfoVO > selectAllDrivingBehalf(PageRequest request);
}
