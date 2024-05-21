package com.example.helloworld;

import com.alibaba.fastjson2.JSON;
import com.example.helloworld.pojo.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FastJsonTest {
    @Test
    public void testFastJSONBasic(){
        Customer customer = new Customer();
        customer.setId(1);
        customer.setPhone("12345678");
        customer.setAge((short)18);
        customer.setName("zhangsan");
        String jsonString = JSON.toJSONString(customer);
        System.out.println(jsonString);
        Customer customer1 = JSON.parseObject(jsonString, Customer.class);
        System.out.println(customer1);
        Assertions.assertEquals(customer.getId(), customer1.getId());
        Assertions.assertEquals(customer.getPhone(), customer1.getPhone());
        Assertions.assertEquals(customer.getAge(), customer1.getAge());
        Assertions.assertEquals(customer.getName(), customer1.getName());
    }
}
