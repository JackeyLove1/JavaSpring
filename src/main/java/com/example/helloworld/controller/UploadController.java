package com.example.helloworld.controller;

import com.example.helloworld.dto.Result;
import com.example.helloworld.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result<String> upload(String name, Integer age, @RequestParam("image")MultipartFile file) throws IOException {
        log.info("File upload name:{}, age: {}, file: {}", name, age, file);
        String uuid = UUID.randomUUID().toString();

        file.transferTo(new File("D:\\data\\" + file.getOriginalFilename()));
        return ResultUtil.success();
    }
}
