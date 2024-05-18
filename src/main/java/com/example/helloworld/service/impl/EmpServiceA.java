package com.example.helloworld.service.impl;

import com.example.helloworld.dao.EmpDao;
import com.example.helloworld.dao.impl.EmpDaoA;
import com.example.helloworld.pojo.Emp;
import com.example.helloworld.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceA implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public List<Emp> listEmp() {
        return empDao.listEmp();
    }
}
