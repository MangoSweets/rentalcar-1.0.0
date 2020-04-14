package com.person.rentalcar;

import com.person.rentalcar.service.CarService;
import com.person.rentalcar.service.client.ClientUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RentalcarApplicationTests {

    @Autowired
    private ClientUserService service;
    @Autowired
    private CarService service1;
    @Test
    void contextLoads() {
        System.out.println(service.getPwdByUsername("admin"));
        System.out.println(service1.getLikeCar("x"));
    }

}
