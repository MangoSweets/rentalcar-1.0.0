package com.person.rentalcar.controller;

import com.person.rentalcar.model.Car;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.response.RespGenerator;
import com.person.rentalcar.service.CarService;
import com.person.rentalcar.vo.query.PageRequest;
import com.person.rentalcar.vo.resp.CarVO;
import com.person.rentalcar.vo.resp.PageResult;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/2/21
 */
@RestController
public class CarController {

    @Autowired
    private CarService service;

    @GetMapping("/car/query")
    @RequiresAuthentication
    public ApiResponse<PageResult> selectAll(PageRequest request) {
        PageResult pageResult = service.selectAll(request);
        return RespGenerator.successful(pageResult);
    }

    @GetMapping("/car/changestatus")
    @RequiresAuthentication
    public ApiResponse changeStatus(boolean status, Integer carId) {
        return service.updateStatus(status, carId);
    }

    @PostMapping("/car/add")
    @RequiresAuthentication
    public ApiResponse addCar(@RequestBody Car car) {
        return service.addCar(car);
    }

    @PostMapping("/car/update")
    @RequiresAuthentication
    public ApiResponse updateCar(@RequestBody Car car) {
        return service.updateCar(car);
    }

    @GetMapping("/car/delete")
    @RequiresAuthentication
    public ApiResponse deleteCar(int carId) {
        return service.deleteCar(carId);
    }

    @GetMapping("/car/getlikecar")
    @RequiresAuthentication
    public ApiResponse<List<CarVO>> getLikeCar(String seriesName) {
        return service.getLikeCar(seriesName);
    }

    @PostMapping("/upload")
    @RequiresAuthentication
    public ApiResponse upload(@RequestParam("picture") MultipartFile picture, HttpServletRequest request) {
        return service.upload(picture, request);
    }
}
