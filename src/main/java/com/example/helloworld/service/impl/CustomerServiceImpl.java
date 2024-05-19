package com.example.helloworld.service.impl;

import com.example.helloworld.mapper.CustomerMapper;
import com.example.helloworld.pojo.Customer;
import com.example.helloworld.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public List<Customer> listAllCustomers() {
        return customerMapper.listAllCustomers();
    }

    @Override
    public void deleteById(Integer id) {
        customerMapper.deleteById(id);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerMapper.insert(customer);
    }

    @Override
    public Long count() {
        return customerMapper.count();
    }

    @Override
    public List<Customer> page(Integer page, Integer pageSize) {
        return customerMapper.page(page, pageSize);
    }
}
