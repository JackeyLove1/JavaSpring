package com.example.helloworld;


import com.example.helloworld.mapper.CustomerMapper;
import com.example.helloworld.pojo.Customer;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@SpringBootTest
public class CustomerTest {
    @Autowired
    private Customer customer;

    @Autowired
    private CustomerMapper customerMapper;

    private final Random random = new Random();
    private final Faker faker = new Faker();

    @Test
    public void testNewCustomer() {
        System.out.println(customer);
    }

    @Test
    public void testDeleteCustomer() {
        customerMapper.deleteById(17);
    }

    @Test
    public void testInsert() {
        Customer customer = new Customer();
        customer.setAge((short) random.nextInt(1, 100));
        customer.setName(faker.name().fullName());
        customer.setGender((short) random.nextInt(0, 2));
        customer.setPhone(faker.phoneNumber().cellPhone());
        customer.setEntryDate(LocalDate.now());
        customerMapper.insert(customer);
        System.out.println(customer.getId());
    }

    @Test
    public void testUpdate() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setAge((short) random.nextInt(1, 100));
        customer.setName(faker.name().fullName());
        customer.setGender((short) random.nextInt(0, 2));
        customer.setPhone(faker.phoneNumber().cellPhone());
        customer.setEntryDate(LocalDate.now());
        customerMapper.update(customer);
        System.out.println(customer);
    }

    @Test
    public void testSelect() {
        Customer customer = customerMapper.getById(1);
        System.out.println(customer);
    }

    @Test
    public void testListByName() {
        customerMapper.listByName("z", (short) 1, LocalDate.of(1900, 1, 1), LocalDate.of(2025, 1, 1))
                .stream().forEach(customer1 -> {
                    System.out.println(customer1);
                });
    }

    @Test
    public void testList() {
        customerMapper.list("c", (short) 1, LocalDate.of(1900, 1, 1), LocalDate.of(2025, 1, 1))
                .stream().forEach(customer1 -> {
                    System.out.println(customer1);
                });

        customerMapper.list("c", null, null, null)
                .stream().forEach(customer1 -> {
                    System.out.println(customer1);
                });

        customerMapper.list(null, (short)0, null, null)
                .stream().forEach(customer1 -> {
                    System.out.println(customer1);
                });
    }

    @Test
    public void testUpdateById(){
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setName("zhangsan");
        customerMapper.updateById(customer1);
    }

    @Test
    @Transactional
    public void testDeleteByIds(){
        customerMapper.deleteByIds(new Integer[]{1,2,3});
    }
}
