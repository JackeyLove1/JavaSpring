package com.example.helloworld.controller;

import com.example.helloworld.dto.Result;
import com.example.helloworld.pojo.Customer;
import com.example.helloworld.service.CustomerService;
import com.example.helloworld.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/login")
    public Result Login(@RequestBody Customer customer) {
        log.info("Customer login: {}", customer);
        Customer result = customerService.Login(customer);
        return result != null ? ResultUtil.success() : ResultUtil.error("用户名或密码错误", 10001);
    }
}
