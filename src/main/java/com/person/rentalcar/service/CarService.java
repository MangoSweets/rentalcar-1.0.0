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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public ApiResponse upload(MultipartFile picture, HttpServletRequest request) {

        //获取文件在服务器的储存位置
        String path = "E:\\image";
//        String path =System.getProperty("user.dir")+"\\src\\main\\resources\\static\\image";
        System.out.println(path);
        File filePath = new File(path);
        System.out.println("文件的保存路径：" + path);
        if (!filePath.exists() && !filePath.isDirectory()) {
            System.out.println("目录不存在，创建目录:" + filePath);
            filePath.mkdir();
        }

        //获取原始文件名称(包含格式)
        String originalFileName = picture.getOriginalFilename();
        System.out.println("原始文件名称：" + originalFileName);

        //获取文件类型，以最后一个`.`为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        System.out.println("文件类型：" + type);
        //获取文件名称（不包含格式）
        String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

        //设置文件新名称: 当前时间+文件名称（不包含格式）
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = sdf.format(d);
        String fileName = date + name + "." + type;
        System.out.println("新文件名称：" + fileName);

        //在指定路径下创建一个文件
        File targetFile = new File(path, fileName);

        //将文件保存到服务器指定位置
        try {
            picture.transferTo(targetFile);
            System.out.println("上传成功");
            //将文件在服务器的存储路径返回
            return RespGenerator.successful("/image/" + fileName);
        } catch (IOException e) {
            System.out.println("上传失败");
            e.printStackTrace();
            return RespGenerator.successful("上传失败");
        }
    }
}
