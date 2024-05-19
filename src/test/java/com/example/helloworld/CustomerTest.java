package com.example.helloworld;


import com.example.helloworld.pojo.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerTest {
    @Autowired
    private Customer customer;

    @Test
    public void testNewCustomer() {
        System.out.println(customer);
    }
}
