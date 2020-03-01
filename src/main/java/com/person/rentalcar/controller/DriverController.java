package com.person.rentalcar.controller;

import com.person.rentalcar.model.DrivingBehalf;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.service.DriverService;
import com.person.rentalcar.vo.query.PageRequest;
import com.person.rentalcar.vo.resp.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/3/1
 */
@RestController
public class DriverController {

    @Autowired
    private DriverService service;

    @GetMapping("/driver/query")
    public ApiResponse<PageResult> selectAllDriver(PageRequest request) {
        return service.selectALLDriver(request);
    }

    @PostMapping("/driver/add")
    public ApiResponse addUser(@RequestBody DrivingBehalf driver) {
        return service.addDriver(driver);
    }

    @GetMapping("/driver/delete")
    public ApiResponse deleteUser(Integer drivingBehalfId) {
        return service.deleteDriver(drivingBehalfId);
    }

    @PostMapping("/driver/update")
    public ApiResponse updateDriver(@RequestBody DrivingBehalf driver){
        return service.updateDriver(driver);
    }

    @GetMapping("/driver/changestatus")
    public ApiResponse changeStatus(Integer driverId,boolean status){
        return service.changeStatus(driverId, status);
    }


}
