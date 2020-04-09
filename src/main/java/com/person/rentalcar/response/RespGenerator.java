package com.person.rentalcar.response;

import com.person.rentalcar.constant.SystemCode;

public final class RespGenerator {
    private RespGenerator() {
    }

    /**
     * @param <T> T
     * @return ApiResponse
     */
    public static <T> ApiResponse<T> successful() {
        return new ApiResponse<T>().setCode(SystemCode.SUCCESS);
    }

    /**
     * @param <T>  T
     * @return ApiResponse
     */
    public static <T> ApiResponse<T> successful(T data) {
        return new ApiResponse<T>().setCode(SystemCode.SUCCESS).setData(data);
//        ApiResponse apiResponse = successful().setParams(args);
//        return apiResponse;
    }

    /**
     * @param code code
     * @param <T>  T
     * @return ApiResponse
     */
    public static <T> ApiResponse<T> fail(String code) {
        ApiResponse apiResponse = new ApiResponse<T>().setCode(code);
        return apiResponse;
    }

    /**
     * @param code code
     * @param args args
     * @param <T>  T
     * @return ApiResponse
     */
    public static <T> ApiResponse<T> fail(String code, Object... args) {
        ApiResponse apiResponse = fail(code).setParams(args);
        return apiResponse;
    }

}
