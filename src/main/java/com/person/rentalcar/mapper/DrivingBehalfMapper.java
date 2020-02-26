package com.person.rentalcar.mapper;

import com.person.rentalcar.model.DrivingBehalf;

import java.util.List;

/**
 * 描述:
 * 版本: v1.0.0
 * 日期：2020/1/15 14:44
 * 作者：yejun
 */
public interface DrivingBehalfMapper {

    boolean addDrivingBehalf(DrivingBehalf drivingBehalf);

    boolean updateDrivingBehalf(DrivingBehalf drivingBehalf);

    boolean deleteDrivingBehalf(int drivingBehalfId);

    DrivingBehalf selectDrivingBehalfByDrivingBehalfId(int drivingBehalfId);

    List<DrivingBehalf> selectAllDrivingBehalf();
}