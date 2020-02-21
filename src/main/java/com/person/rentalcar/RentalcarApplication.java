package com.person.rentalcar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.person.rentalcar.mapper"})
public class RentalcarApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentalcarApplication.class, args);
    }

}
