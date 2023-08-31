package com.dsy.dubbomockserver.bean.base;

import lombok.Data;

/**
 * @Author: dongshuaiyin
 * @Description:
 * @Date: 2023/4/26 17:45
 * @Modified by:
 */
@Data
public class ResultDto<T> {

    protected Integer code;
    protected String message;

    protected T data;

    public ResultDto() {
    }

    public ResultDto(T data) {
        this.code = 0;
        this.message = "";
        this.data = data;
    }

    public ResultDto(T data, String msg) {
        this.code = 0;
        this.message = msg;
        this.data = data;
    }

    public ResultDto(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> ResultDto<T> success(T data) {
        return success("成功", data);
    }

    public static <T> ResultDto<T> success(String message, T data) {
        ResultDto<T> resultDto = new ResultDto(0, message);
        resultDto.setData(data);
        return resultDto;
    }

    public static <T> ResultDto<T> error(String msg) {
        return error(1, msg);
    }

    public static <T> ResultDto<T> error(int code, String msg) {
        ResultDto<T> resultDto = new ResultDto(code, msg);
        return resultDto;
    }
}
