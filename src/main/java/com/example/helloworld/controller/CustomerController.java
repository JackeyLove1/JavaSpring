package com.example.helloworld.controller;

import com.example.helloworld.dto.Result;
import com.example.helloworld.mapper.CustomerMapper;
import com.example.helloworld.pojo.Customer;
import com.example.helloworld.service.CustomerService;
import com.example.helloworld.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {
    // private static Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    // @RequestMapping(value = "/customer", method = RequestMethod.GET)
    @GetMapping
    public Result<List<Customer>> listAllCustomers() {
        log.info("query all customers");
        return ResultUtil.success(customerService.listAllCustomers());
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteById(@PathVariable Integer id) {
        log.info("delete by id:{}", id);
        customerService.deleteById(id);
        return ResultUtil.success();
    }

    @PostMapping
    public Result<Customer> addCustomer(@RequestBody Customer customer) {
        log.info("add customer:{}", customer);
        customerService.addCustomer(customer);
        return ResultUtil.success();
    }

    @GetMapping("/page")
    public Result<List<Customer>> page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("分页查询");
        return ResultUtil.success(customerService.page(page, pageSize));
    }

    @GetMapping("/count")
    public Result<Long> count() {
        return ResultUtil.success(customerService.count());
    }

}
