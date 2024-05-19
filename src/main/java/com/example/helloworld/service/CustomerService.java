package com.example.helloworld.service;

import com.example.helloworld.pojo.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    List<Customer> listAllCustomers();

    void deleteById(Integer id);

    void addCustomer(Customer customer);

    Long count();

    List<Customer> page(Integer page, Integer pageSize);
}
