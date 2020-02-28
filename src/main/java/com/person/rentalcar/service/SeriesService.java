package com.person.rentalcar.service;

import com.person.rentalcar.mapper.SeriesMapper;
import com.person.rentalcar.model.Series;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.response.RespGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/2/26
 */
@Service
public class SeriesService {

    @Autowired
    private SeriesMapper mapper;

    public ApiResponse<List<Map<String, String>>> getSeriesIdAndName() {
        List<Series> seriesList = mapper.SeriesForIdAndname();
        List list=new ArrayList();
        for (Series s : seriesList) {
            Map map = new HashMap();
            map.put("seriesId",s.getSeriesId());
            map.put("seriesName", s.getSeriesName());
            list.add(map);
        }
        return RespGenerator.successful(list);
    }

}
