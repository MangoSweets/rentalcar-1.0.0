package com.person.rentalcar.controller;

import com.person.rentalcar.model.Series;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.response.RespGenerator;
import com.person.rentalcar.service.SeriesService;
import com.person.rentalcar.vo.query.PageRequest;
import com.person.rentalcar.vo.resp.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/2/26
 */
@RestController
public class SeriesController {

    @Autowired
    private SeriesService seriesService;

    @GetMapping("/series/getSeriesIdAndName")
    public ApiResponse<List<Map<String, String>>> getSeriesNameAndId() {
        return seriesService.getSeriesIdAndName();
    }

    @GetMapping("/series/query")
    public ApiResponse<PageResult> selectAllSeries(PageRequest request) {
        return RespGenerator.successful(seriesService.selectAllSeries(request));
    }

    @PostMapping("/series/add")
    public  ApiResponse addSeries(@RequestBody Series series){
        return seriesService.addSeries(series);
    }

    @PostMapping("/series/update")
    public  ApiResponse updateSeries(@RequestBody Series series){
        return seriesService.updateSeries(series);
    }

    @GetMapping("/series/delete")
    public  ApiResponse deleteSeries(int seriesId){
        return seriesService.deleteSeries(seriesId);
    }

    @GetMapping("/series/changestatus")
    public  ApiResponse changeStatus(boolean status,int seriesId){
        return seriesService.changeStatus(status,seriesId);
    }
}
