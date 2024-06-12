package com.atguigu.cloud.resp;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ReturnCodeEnum {
    RC200("200", "操作成功"),
    RC404("404", "找不到对象"),
    RC500("500", "内部错误"),
    ;

    private final String code;
    private final String message;

    ReturnCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ReturnCodeEnum getReturnCodeEnumV1(String code) {
        for (ReturnCodeEnum element : ReturnCodeEnum.values()) {
            if (element.getCode().equalsIgnoreCase(code)){
                return element;
            }
        }
        return null;
    }

    public static ReturnCodeEnum getReturnCodeEnumV2(String code) {
        return Arrays.stream(ReturnCodeEnum.values()).filter(x -> x.getCode().equalsIgnoreCase(code)).findFirst().orElse(null);
    }

    public static void main(String[] args) {
        System.out.println(ReturnCodeEnum.getReturnCodeEnumV1("200"));
        System.out.println(ReturnCodeEnum.getReturnCodeEnumV1("200").getCode());
        System.out.println(ReturnCodeEnum.getReturnCodeEnumV1("200").getMessage());

        System.out.println(ReturnCodeEnum.getReturnCodeEnumV1("403"));
        System.out.println(ReturnCodeEnum.getReturnCodeEnumV1("403").getCode());
        System.out.println(ReturnCodeEnum.getReturnCodeEnumV1("403").getMessage());
    }
}
