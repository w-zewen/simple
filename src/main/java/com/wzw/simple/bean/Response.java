package com.wzw.simple.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回对象
 *
 * @author zewen.wang
 * @date 2022/12/24
 */
@Data
public class Response<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    private static Integer success = 200;
    private static Integer fail = 500;

    public Response(){

    }

    public Response(Integer code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Response success(Object data){
        return new Response(success, "success", data);
    }

    public static Response fail(String message){
        return new Response(fail, message, null);
    }

}
