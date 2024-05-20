package com.example.helloworld;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class UuidTest {
    @Test
    public void testUUIDGenerate() {
        for(int i = 0; i < 10; i++){
            System.out.println(UUID.randomUUID().toString());
        }
    }
}
