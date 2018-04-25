package com.xwtech.web.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * java接口统一返回格式
 * @author gdy
 * @date  2017/8/21.
 * 办证保证序列化JSON的时候，如果是null对象， key也会消失
 */

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable {

    private int status ;
    private String msg ;
    private T data ;
    private ServerResponse(int status){
        this.status = status;
    }
    private ServerResponse(int status , T data){
        this.status = status;
        this.data = data;
    }
    private ServerResponse(int status , String msg , T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    private ServerResponse(int status , String msg){
        this.status = status;
        this.msg = msg;
    }


    /**
     *
     * 判断是否处理成功
     *
     * JsonIgnore: 使之不在序列化结果中
     */
    @JsonIgnore
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus(){
        return  status;
    }
    public String getMsg(){
        return msg;
    }
    public T getData(){
        return data;
    }

    /**
     * 调用成功的构造方法
     * @param <T> 处理结果类型
     * @return  "处理成功的status"
     */
    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    /**
     * 调用成功，返回成功信息
     * @param msg 成功的提示信息
     * @param <T> 处理结果类型
     * @return  成功的代码与提示信息
     */
    public static <T> ServerResponse<T> createBySuccesMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode() , msg);
    }

    /**
     * 调用成功， 返回成功的数据
     * @param data 处理后的数据
     * @param <T> 处理结果类型
     * @return 成功的代码与数据
     */
    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode() , data);
    }

    /**
     * 调用成功，返回成功信息和数据
     * @param msg 提示信息
     * @param data 数据
     * @param <T> 处理的数据类型
     * @return 成功的代码，提示信息 ， 数据
     */
    public static <T> ServerResponse<T> createBySuccess(String msg , T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode() , msg , data);
    }

    /**
     * 失败的构造方法
     * @param <T> 处理的数据类型
     * @return 错误的代码 和 说明
     */
    public static <T> ServerResponse<T> createByError(){
        return  new ServerResponse<T>(ResponseCode.ERROR.getCode() , ResponseCode.ERROR.getDesc());
    }

    /**
     * 调用失败，返回失败代码 和 信息
     * @param errorMessage  错误提示
     * @param <T> 处理的数据类型
     * @return 错误的代码 和 提示信息
     */
    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode() , errorMessage);
    }

    /**
     * 调用失败，返回失败代码 和 信息
     * @param errorCOde  错误代码
     * @param errorMessage 错误的提示信息
     * @param <T> 处理的数据类型
     * @return 错误代码和提示信息
     */
    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCOde ,String errorMessage ){
        return new ServerResponse<T>(errorCOde, errorMessage);
    }
}
























