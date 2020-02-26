package com.person.rentalcar.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.person.rentalcar.convert.CarConvert;
import com.person.rentalcar.dto.CarDTO;
import com.person.rentalcar.mapper.CarMapper;
import com.person.rentalcar.mapper.SeriesMapper;
import com.person.rentalcar.model.Car;
import com.person.rentalcar.model.Series;
import com.person.rentalcar.utils.pagehelper.PageUtils;
import com.person.rentalcar.vo.query.PageRequest;
import com.person.rentalcar.vo.resp.CarVO;
import com.person.rentalcar.vo.resp.PageResult;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/2/21
 */
@Service
public class CarService {

    @Autowired
    private CarMapper mapper;

    @Autowired
    private SeriesMapper seriesMapper;

    public PageResult selectAll(PageRequest request) {

        int pageNum = request.getPageNum();
        int pageSize = request.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Car> cars = mapper.selectAllCar(request);
        List<CarDTO> carDTOS = CarConvert.convertToCarDTOList(cars);
        List<Series> seriesList = seriesMapper.selectAllSeries();
        Map<Integer, String> map = new HashedMap();
        for (Series series : seriesList) {
            map.put(series.getSeriesId(), series.getSeriesName());
        }
        for (CarDTO carDTO : carDTOS) {
            carDTO.setSeriesName(map.get(carDTO.getSeriesId()));
        }
        List<CarVO> carVOS = CarConvert.convertToCarVOList(carDTOS);
        PageInfo<CarVO> carVOPageInfo = new PageInfo<>(carVOS);
        carVOPageInfo.setPageNum(request.getPageNum());
        carVOPageInfo.setPageSize(request.getPageSize());

        return PageUtils.getPageResult(carVOPageInfo);
    }
}
