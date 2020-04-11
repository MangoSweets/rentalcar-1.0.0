package com.person.rentalcar.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.person.rentalcar.convert.CarConvert;
import com.person.rentalcar.dto.CarDTO;
import com.person.rentalcar.mapper.CarMapper;
import com.person.rentalcar.mapper.SeriesMapper;
import com.person.rentalcar.model.Car;
import com.person.rentalcar.model.Series;
import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.response.RespGenerator;
import com.person.rentalcar.utils.DateUtils;
import com.person.rentalcar.utils.pagehelper.PageUtils;
import com.person.rentalcar.vo.query.PageRequest;
import com.person.rentalcar.vo.resp.CarVO;
import com.person.rentalcar.vo.resp.PageResult;
import org.apache.commons.collections4.map.HashedMap;
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
        List<Series> seriesList = seriesMapper.selectAllSeries(new PageRequest());
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
        carVOPageInfo.setTotal(mapper.getTotalSize());
        carVOPageInfo.setList(carVOS);
        return PageUtils.getPageResult(carVOPageInfo);
    }

    public ApiResponse updateStatus(boolean status, int carId) {
        boolean b = mapper.updateStatus(status, carId);
        if (b) {
            return RespGenerator.successful().setMessage("更改状态成功");
        }
        return RespGenerator.fail("400").setMessage("参数格式错误");
    }

    public ApiResponse addCar(Car car) {
        car.setCarCreateTime(DateUtils.parseDateTime(DateUtils.getCurrentDatetime()));
        boolean b = mapper.addCar(car);
        if (b) {
            return RespGenerator.successful().setMessage("添加车辆成功");
        }
        return RespGenerator.fail("400").setMessage("添加车辆失败，请检查参数");

    }

    public ApiResponse updateCar(Car car) {
        car.setCarUpdateTime(DateUtils.parseDateTime(DateUtils.getCurrentDatetime()));
        boolean b = mapper.updateCar(car);
        if (b) {
            return RespGenerator.successful().setMessage("汽车编辑成功");
        }
        return RespGenerator.fail("400").setMessage("汽车编辑失败，请检查参数");

    }

    public ApiResponse deleteCar(int carId) {
        boolean b = mapper.deleteCar(carId);
        if (b) {
            return RespGenerator.successful().setMessage("删除成功");
        }
        return RespGenerator.fail("400").setMessage("删除失败，请检查参数");
    }

    public ApiResponse<List<CarVO>> getLikeCar(String seriesName) {
        return RespGenerator.successful(mapper.getLikeCar(seriesName));
    }
}
