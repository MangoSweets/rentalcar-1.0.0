package com.person.rentalcar.exception;

import com.person.rentalcar.response.ApiResponse;
import com.person.rentalcar.response.RespGenerator;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @describtion: 全局异常处理器, 用于异常的捕获。
 * @author: yejun
 * @time: 2020/4/4
 */
@ControllerAdvice
public class GloabllExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ApiResponse handlerException(Exception e){
        e.printStackTrace();
        return RespGenerator.fail("300001",e.getMessage()!=null?e.getMessage():"服务器发生错误");
    }
}
