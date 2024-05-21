package com.example.helloworld.controller;

import com.example.helloworld.dto.Result;
import com.example.helloworld.pojo.Customer;
import com.example.helloworld.service.CustomerService;
import com.example.helloworld.util.JwtUtils;
import com.example.helloworld.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/login")
    public Result<String> Login(@RequestBody Customer customer) {
        log.info("Customer login: {}", customer);
        Customer result = customerService.Login(customer);
        if (result != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", result.getId());
            claims.put("name", result.getName());
            claims.put("username", result.getUsername());
            String token = JwtUtils.generateJwt(claims);
            return ResultUtil.success(token);
        }
        return ResultUtil.error("用户名或密码错误", 10001);
    }
}
