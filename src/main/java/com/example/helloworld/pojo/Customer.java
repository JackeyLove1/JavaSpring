package com.example.helloworld.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class Customer {
    private Integer id;
    private String name;
    private Short age;
    private Short gender;
    private String phone;
    private LocalDate entryDate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String username;
    private String password;
    private String avatar;
}
