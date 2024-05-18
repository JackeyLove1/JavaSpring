package com.example.helloworld;

import com.example.helloworld.mapper.Student;
import com.example.helloworld.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestStudentMapper {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void TestPrintAllStudent(){
        List<Student> students = studentMapper.findAll();
        students.forEach(System.out::println);
    }

    @Test
    public void TestPrintStudentById(){
        Student student = studentMapper.findById(1);
        System.out.println(student);
    }


    @Test
    public void TestInsertStudent(){
        // studentMapper.insert(5,"James", 20);
    }

    @Test
    public void TestUpdateStudent(){
        Student student = new Student(1,"James", 20);
        studentMapper.update(student);
    }

    @Test
    public void TestDeleteStudent(){
        studentMapper.delete(1);
    }
}
