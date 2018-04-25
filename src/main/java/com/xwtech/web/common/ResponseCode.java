package com.xwtech.web.common;

/**
 * @author gdy
 * Created by RS on 2017/8/21.
 */
public enum ResponseCode {
    /**success*/
    SUCCESS(0,"SUCCESS"),
    /**error*/
    ERROR(1,"ERROR");

    private final int code;
    private final String desc;
    ResponseCode(int code , String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return  code;
    }

    public String getDesc(){
        return desc;
    }

}
