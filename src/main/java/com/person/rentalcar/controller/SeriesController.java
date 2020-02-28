package com.person.rentalcar.controller;

import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
