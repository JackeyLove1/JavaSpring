package com.example.helloworld;

import com.example.helloworld.controller.CustomerController;
import com.example.helloworld.service.CustomerService;
import com.example.helloworld.util.ResultUtil;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
@Slf4j
public class BeanTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testBean() {
        CustomerController customerController = (CustomerController) applicationContext.getBean("customerController");
        System.out.println(customerController);

        CustomerController customerController2 = (CustomerController) applicationContext.getBean(CustomerController.class);
        System.out.println(customerController2);

    }

    @Autowired
    private Gson gson;
    @Test
    public void testGson(){
        String json = gson.toJson(ResultUtil.success());
        System.out.println(json);
    }

}
