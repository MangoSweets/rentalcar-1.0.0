package com.person.rentalcar.controller;

import com.person.rentalcar.model.Car;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.response.RespGenerator;
import com.person.rentalcar.service.CarService;
import com.person.rentalcar.vo.query.PageRequest;
import com.person.rentalcar.vo.resp.CarVO;
import com.person.rentalcar.vo.resp.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public ApiResponse<PageResult> selectAll(PageRequest request) {
        PageResult pageResult = service.selectAll(request);
        return RespGenerator.successful(pageResult);
    }

    @GetMapping("/car/changestatus")
    public ApiResponse changeStatus(boolean status, Integer carId) {
        return service.updateStatus(status, carId);
    }

    @PostMapping("/car/add")
    public ApiResponse addCar(@RequestBody Car car) {
        return service.addCar(car);
    }

    @PostMapping("/car/update")
    public ApiResponse updateCar(@RequestBody Car car) {
        return service.updateCar(car);
    }

    @GetMapping("/car/delete")
    public ApiResponse deleteCar(int carId) {
        return service.deleteCar(carId);
    }

    @GetMapping("/car/getlikecar")
    public ApiResponse<List<CarVO>> getLikeCar(String seriesName) {
        return service.getLikeCar(seriesName);
    }
}
