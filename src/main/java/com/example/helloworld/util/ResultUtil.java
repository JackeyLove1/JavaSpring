package com.example.helloworld.util;

import com.example.helloworld.dto.Result;

public class ResultUtil {
    public static <T> Result<T> success(T data) {
        return new Result<T>("success", data, 200);
    }

    public static <T> Result<T> success(String msg, T data) {
        return new Result<>(msg, data, 200);
    }

    public static <T> Result<T> error(String msg, int code) {
        return new Result<>(msg, null, code);
    }

    public static <T> Result<T> error(String msg, int code, T data) {
        return new Result<>(msg, data, code);
    }
}
