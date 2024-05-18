package com.example.helloworld;

import static org.junit.jupiter.api.Assertions.*;
import com.example.helloworld.mapper.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

@SpringBootTest
public class TestStudent {
    @Test
    public void TestStudentEqual() throws CloneNotSupportedException{
        Student s1 = new Student(1, "张三", 20);
        Student s2 = new Student(2, "李四", 21);
        System.out.println(s1.equals(s2));
        assertNotEquals(s1, s2);

        Student s3 = (Student) s1.clone();
        assertEquals(s1, s3);

        assertTrue(Objects.equals(s1, s3));

        assertNotNull(s3);


    }
}
