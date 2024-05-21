package com.example.helloworld.exception;

import com.example.helloworld.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result<String> ex(Exception ex){
        log.error("Internal Error");
        ex.printStackTrace();
        return new Result<>("服务器异常，请联系管理员", null, 500);
    }
}
