package com.person.rentalcar.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.person.rentalcar.mapper.SeriesMapper;
import com.person.rentalcar.model.Series;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.response.RespGenerator;
import com.person.rentalcar.utils.pagehelper.PageUtils;
import com.person.rentalcar.vo.query.PageRequest;
import com.person.rentalcar.vo.resp.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
        List list = new ArrayList();
        for (Series s : seriesList) {
            Map map = new HashMap();
            map.put("seriesId", s.getSeriesId());
            map.put("seriesName", s.getSeriesName());
            list.add(map);
        }
        return RespGenerator.successful(list);
    }


    public PageResult selectAllSeries(@RequestBody PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Series> seriesList = mapper.selectAllSeries(request);
        return PageUtils.getPageResult(new PageInfo<>(seriesList));
    }

    public ApiResponse addSeries(Series series) {
        boolean b = mapper.addSeries(series);
        if (b) {
            return RespGenerator.successful().setMessage("成功添加一个系列");
        }
        return RespGenerator.fail("400").setMessage("添加失败，请检查参数");
    }

    public ApiResponse updateSeries(Series series) {
        boolean b = mapper.updateSeries(series);
        if (b) {
            return RespGenerator.successful().setMessage("更新成功");
        }
        return RespGenerator.fail("400").setMessage("更新失败，请检查参数");

    }

    public ApiResponse deleteSeries(int seriesId) {
        boolean b = mapper.deleteSeriesBySeriesId(seriesId);
        if (b) {
            return RespGenerator.successful().setMessage("删除成功");
        }
        return RespGenerator.fail("400").setMessage("删除失败，请检查参数");
    }

    public ApiResponse changeStatus(boolean status, int seriesId) {
        boolean b = mapper.changeStatus(status,seriesId);
        if (b) {
            return RespGenerator.successful().setMessage("成功修改状态");
        }
        return RespGenerator.fail("400").setMessage("状态修改失败，请检查参数");
    }
}
