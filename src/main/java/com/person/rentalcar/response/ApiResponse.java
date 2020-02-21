package com.person.rentalcar.response;

import com.person.rentalcar.constant.SystemCode;
import lombok.*;

/**
 * 描述:
 * 版本: v1.0.0
 * 日期：2020/1/14 15:36
 * 作者：yejun
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiResponse<T extends Object> {

    @Getter
    private String code;
    @Getter
    private Object[] params;
    @Getter
    private String message;
    @Getter
    private T data;

    /**
     * 异常产生源头应用app code.
     */
    @Getter
    private String appCodeForEx;

    /**
     * 异常产生源头error code.
     */
    @Getter
    private String originalErrorCode;

    /**
     * rid
     */
    @Setter
    @Getter
    private String rid;

    public ApiResponse<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public ApiResponse<T> setAppCode(String appCodeForEx) {
        this.appCodeForEx = appCodeForEx;
        return this;
    }

    public ApiResponse<T> setOriginalErrorCode(String originalErrorCode) {
        this.originalErrorCode = originalErrorCode;
        return this;
    }

    public ApiResponse<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public ApiResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public ApiResponse<T> setParams(Object[] params) {
        this.params = params;
        return this;
    }

    public static boolean isSuccess(ApiResponse<?>  apiResponse) {
        boolean success = false;
        if (apiResponse == null) {
            return success;
        }
        if (SystemCode.SUCCESS.equals(apiResponse.getCode())) {
            success = true;
        }
        return success;
    }
}
