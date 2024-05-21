package com.example.helloworld.service.impl;

import com.example.helloworld.aop.MyLog;
import com.example.helloworld.mapper.CustomerMapper;
import com.example.helloworld.pojo.Customer;
import com.example.helloworld.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public List<Customer> listAllCustomers() {
        return customerMapper.listAllCustomers();
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void deleteById(Integer id) {
        customerMapper.deleteById(id);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerMapper.insert(customer);
    }

    @MyLog
    @Override
    public Long count() {
        return customerMapper.count();
    }

    @MyLog
    @Override
    public List<Customer> page(Integer page, Integer pageSize) {
        return customerMapper.page(page, pageSize);
    }

    @Override
    public Customer Login(Customer customer) {
        return customerMapper.login(customer);
    }
}
