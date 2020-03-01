package com.person.rentalcar.controller;

import com.person.rentalcar.mapper.*;
import com.person.rentalcar.model.*;
import com.person.rentalcar.vo.query.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/1/17
 */
@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/test/user/add")
    public void addUser() {
        userMapper.addUser(new User().setUsername("yejun").setPassword("123456").setName("yejun").setSex("男").setTelephone("5651").setIDCard("1222323").setUserStatus(true));
        System.out.println("添加成功");
    }

    @RequestMapping("/test/user/update")
    public void updateUser() {
        userMapper.updateUser(new User().setUserId(1).setPassword("123"));
        System.out.println("更新成功");
    }

    @RequestMapping("/test/user/selectuser")
    public void selectUser() {
        System.out.println(userMapper.selectUserByUsername("yejun"));
    }

    @RequestMapping("/test/user/selectall")
    public void selectAllUser() {
//        System.out.println(userMapper.selectAllUser());
    }

    @RequestMapping("/test/user/delete")
    public void deleteUser() {
        userMapper.deleteUser(1);
        System.out.println("删除");
    }

    //-------------------------------------------------------------------

    @Autowired
    private CarMapper carMapper;

    @RequestMapping("/test/car/add")
    public void addCar() {
        carMapper.addCar(new Car().setCarStatus(true).setPlateNumber("888888"));
        System.out.println("添加成功");
    }

    @RequestMapping("/test/car/update")
    public void updateCar() {
        carMapper.updateCar(new Car().setCarId(1).setPlateNumber("666666"));
        System.out.println("更新成功");
    }

    @RequestMapping("/test/car/selectuser")
    public void selectCar() {
        System.out.println(carMapper.selectCarByCarId(1));
    }

    @RequestMapping("/test/car/query")
    public void selectAllCer(PageRequest request) {
        System.out.println(carMapper.selectAllCar(request));
    }

//    @RequestMapping("/test/car/delete")
//    public void deleteCer() {
//        carMapper.deleteCar(1);
//        System.out.println("删除");
//    }

    //-------------------------------------------------------------------

    @Autowired
    private AdministratorMapper administratorMapper;


    @RequestMapping("/test/administrator/add")
    public void addadministrator() {
        administratorMapper.addAdministrator(new Administrator().setAdminStatus(true).setAdmin("admin").setPassword("123456"));
        System.out.println("添加成功");
    }

    @RequestMapping("/test/administrator/update")
    public void updateadministrator() {
        administratorMapper.updateAdministrator(new Administrator().setAdministratorId(1).setPassword("666666"));
        System.out.println("更新成功");
    }

    @RequestMapping("/test/administrator/selectuser")
    public void selectadministrator() {
        System.out.println(administratorMapper.selectAdministratorByadmin("admin"));
    }

    @RequestMapping("/test/administrator/selectall")
    public void selectAlladministrator() {
        System.out.println(administratorMapper.selectAllAdministrator());
    }

    @RequestMapping("/test/administrator/delete")
    public void deleteadministrator() {
        administratorMapper.deleteAdministrator(1);
        System.out.println("删除");
    }

    //------------------------------------------------------------------------------

    @Autowired
    private DrivingBehalfMapper drivingBehalfMapper;

    @RequestMapping("/test/drivingBehalfMapper/add")
    public void adddrivingBehalfMapper() {
        drivingBehalfMapper.addDrivingBehalf(new DrivingBehalf().setDrivingStatus(true).setDrivingName("admin").setBehalfLicense("123456"));
        System.out.println("添加成功");
    }

    @RequestMapping("/test/drivingBehalfMapper/update")
    public void updatedrivingBehalfMapper() {
        drivingBehalfMapper.updateDrivingBehalf(new DrivingBehalf().setDrivingBehalfId(1).setBehalfLicense("666666"));
        System.out.println("更新成功");
    }

    @RequestMapping("/test/drivingBehalfMapper/selectuser")
    public void selectdrivingBehalfMapper() {
        System.out.println(drivingBehalfMapper.selectDrivingBehalfByDrivingBehalfId(1));
    }

    @RequestMapping("/test/drivingBehalfMapper/selectall")
    public void selectAlldrivingBehalfMapper() {
//        System.out.println(drivingBehalfMapper.selectAllDrivingBehalf());
    }

    @RequestMapping("/test/drivingBehalfMapper/delete")
    public void deletedrivingBehalfMapper() {
        drivingBehalfMapper.deleteDrivingBehalf(1);
        System.out.println("删除");
    }

    //----------------------------------------------------------------------

    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping("/test/OrderMapper/add")
    public void addOrderMapper() {
        orderMapper.addOrder(new Order().setStatus(true).setUserId(1).setCarId(1));
        System.out.println("添加成功");
    }

    @RequestMapping("/test/OrderMapper/update")
    public void updateOrderMapper() {
        orderMapper.updateOrder(new Order().setCarId(2).setOrderId(1));
        System.out.println("更新成功");
    }

    @RequestMapping("/test/OrderMapper/selectuser")
    public void selectOrderMapper() {
        System.out.println(orderMapper.selectOrderByOrderId(1));
    }

    @RequestMapping("/test/OrderMapper/selectall")
    public void selectAllOrderMapper() {
        System.out.println(orderMapper.selectAllOrder());
    }

    @RequestMapping("/test/OrderMapper/delete")
    public void deleteOrderMapper() {
        orderMapper.deleteOrder(1);
        System.out.println("删除");
    }

    //------------------------------------------------------------

    @Autowired
    private SeriesMapper seriesMapper;

    @RequestMapping("/test/seriesMapper/add")
    public void addseriesMapper() {
        seriesMapper.addSeries(new Series().setSeriesStatus(true).setBrand("宝马"));
        System.out.println("添加成功");
    }

    @RequestMapping("/test/seriesMapper/update")
    public void updateseriesMapper() {
        seriesMapper.updateSeries(new Series().setBrand("法拉利").setSeriesId(1));
        System.out.println("更新成功");
    }

    @RequestMapping("/test/seriesMapper/selectuser")
    public void selectseriesMapper() {
        System.out.println(seriesMapper.selectSeriesBySeriesId(1));
    }

    @RequestMapping("/test/seriesMapper/selectall")
    public void selectAllseriesMapper() {
//        System.out.println(seriesMapper.selectAllSeries());
    }

    @RequestMapping("/test/seriesMapper/delete")
    public void deleteseriesMapper() {
        seriesMapper.deleteSeriesBySeriesId(1);
        System.out.println("删除");
    }
}
