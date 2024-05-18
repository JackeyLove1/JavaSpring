package com.example.helloworld.controller;

import com.example.helloworld.dto.Result;
import com.example.helloworld.pojo.Emp;
import com.example.helloworld.service.EmpService;
import com.example.helloworld.service.impl.EmpServiceA;
import com.example.helloworld.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping("/listEmp")
    public Result<List<Emp>> listEmp() {
        return ResultUtil.success(empService.listEmp());
    }
}
