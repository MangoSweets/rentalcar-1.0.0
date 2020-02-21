package com.person.rentalcar.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/1/20
 */
@Configuration
public class ErrorConfig implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage error404Page=new ErrorPage(HttpStatus.NOT_FOUND,"/index.html");
        registry.addErrorPages(error404Page);
    }
}
