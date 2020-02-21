package com.person.rentalcar.Enum;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RespcodeEnum {
    SUCCESS("200", "SUCCESS"),
    FAILD("400", "登录失败");

    private String code;
    private String text;

    public String getCode() {
        return this.code;
    }

    public String getText() {
        return this.text;
    }
}
