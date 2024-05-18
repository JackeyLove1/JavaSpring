package com.example.helloworld;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestFaker {
    private final Faker faker = new Faker();
    @Test
    public void TestFakerBasic(){
        System.out.println(faker.name().fullName());
        System.out.println(faker.address().fullAddress());
        System.out.println(faker.address().city());
        System.out.println(faker.address().state());
        System.out.println(faker.address().country());
        System.out.println(faker.address().zipCode());
    }
}
