package com.person.rentalcar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @describtion:
 * @author: yejun
 * @time: 2020/1/18
 */
@Configuration
public class MyWebConfigurer implements WebMvcConfigurer {

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/image/**").addResourceLocations("classpath:/static/image/");
//        registry.addResourceHandler("/static/image/**").addResourceLocations("file:" + UploadUtils.getImgDirFile().getAbsolutePath() + "/");  //添加这一行
//    }
}
