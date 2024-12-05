package com.wzb.pojo;

/**
 * 统一的响应类，包含请求状态码、响应数据、响应信息
 *
 * @param <T>
 */
public class Result<T> {
    private Integer code; //状态码：1成功，0和其它数字为失败
    private T data; // 可能会返回的数据
    private String message; // 错误信息

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.code = 1;
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.code = 1;
        result.data = data;
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.code = 0;
        result.message = msg;
        return result;
    }

}


