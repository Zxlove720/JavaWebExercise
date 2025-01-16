package com.wzb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一响应结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    // 响应代码 1：成功 0：失败
    private Integer code;
    // 错误信息
    private String msg;
    // 可能会返回数据
    private T data;

    /**
     * 成功响应-无返回数据
     * @return 无返回数据的result
     */
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.code = 1;
        return result;
    }

    /**
     * 成功响应-有返回数据
     * @param data 返回数据
     * @return 有返回数据的result
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.code = 1;
        result.data = data;
        return result;
    }

    /**
     * 响应失败-有错误信息
     * @param msg 错误信息
     */
    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.code = 0;
        result.msg = msg;
        return result;
    }
}
