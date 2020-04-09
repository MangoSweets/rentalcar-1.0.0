package com.person.rentalcar.config;

///**
// * @describtion:
// * @author: yejun
// * @time: 2020/1/18
// */
//@SpringBootConfiguration
//public class MyWebConfigurer implements WebMvcConfigurer {

//    @Bean
//    public InterceptorConfig getLoginInterceptor(){
//        return new InterceptorConfig();
//    }
////
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        //所有请求都允许跨域
//        registry.addMapping("/**")
//                .allowCredentials(true)
//                .allowedOrigins("http://localhost:8080")
//                .allowedMethods("POST","GET","PUT","DELETE","OPTIONS")
//                .allowedHeaders("*");
//    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(getLoginInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/index.html")
//                .excludePathPatterns("/api/login")
//                .excludePathPatterns("/api/logout");
//    }
//}
