package com.person.rentalcar.service;

import com.person.rentalcar.mapper.SeriesMapper;
import com.person.rentalcar.model.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Map<String, String> getSeriesIdAndName() {
        List<Series> seriesList = mapper.SeriesForIdAndname();
        Map map = new HashMap();
        for (Series s : seriesList) {
            map.put(s.getSeriesId(), s.getSeriesName());
        }
        return map;
    }

}
