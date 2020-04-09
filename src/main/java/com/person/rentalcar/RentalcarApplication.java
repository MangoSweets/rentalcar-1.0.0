package com.person.rentalcar;

import com.person.rentalcar.shiro.security.JwtProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({JwtProperties.class})
@MapperScan(basePackages = {"com.person.rentalcar.mapper"})
public class RentalcarApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentalcarApplication.class, args);
    }

}
