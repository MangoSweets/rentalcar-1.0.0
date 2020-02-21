package com.person.rentalcar.mapper;

import com.person.rentalcar.model.Car;

import java.util.List;

public interface CarMapper {

    boolean addCar(Car car);

    boolean updateCar(Car car);

    boolean deleteCar(int carId);

    Car selectCarByCarId(int carId);

    List<Car> selectAllCar();
}
