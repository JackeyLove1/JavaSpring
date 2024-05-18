package com.example.helloworld.dao.impl;

import com.example.helloworld.dao.EmpDao;
import com.example.helloworld.pojo.Emp;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpDaoA implements EmpDao {

    public List<Emp> listEmp(){
        List<Emp> list = new java.util.ArrayList<>();
        for (int i = 0; i < 3; i++){
            list.add(Emp.getRandomEmp());
        }
        return list;
    }
}
