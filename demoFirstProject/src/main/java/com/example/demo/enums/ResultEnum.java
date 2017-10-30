package com.example.demo.enums;

public enum ResultEnum {
    SUCCESSED(0, "successed"),
    FAILED(-1, "failed"),
    DIY(2, "DIY");


    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
