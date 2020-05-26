package com.person.rentalcar.controller;

import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.service.DriverService;
import com.person.rentalcar.vo.query.PageRequest;
import com.person.rentalcar.vo.resp.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/driver/add")
    public ApiResponse addUser(String username) {
        return service.addDriver(username);
    }

    @GetMapping("/driver/delete")
    public ApiResponse deleteUser(Integer drivingBehalfId) {
        return service.deleteDriver(drivingBehalfId);
    }


}
