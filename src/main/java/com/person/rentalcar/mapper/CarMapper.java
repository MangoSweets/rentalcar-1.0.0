package com.person.rentalcar.mapper;

import com.person.rentalcar.model.Car;
import com.person.rentalcar.vo.query.PageRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {

    boolean addCar(Car car);

    boolean updateCar(Car car);

    boolean updateStatus(@Param("status") boolean status,@Param("carId") Integer carId);

    Car selectCarByCarId(int carId);

    List<Car> selectAllCar(PageRequest request);

    Long getTotalSize();

    boolean deleteCar(int carId);
}
