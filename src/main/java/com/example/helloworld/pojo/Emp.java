package com.example.helloworld.pojo;

import com.github.javafaker.Faker;

public class Emp {
    private int id;
    private String name;
    private int age;
    private String email;

    private static final Faker faker = new Faker();

    public Emp() {
    }

    public Emp(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "age=" + age +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static Emp getRandomEmp() {
        return new Emp(faker.idNumber().hashCode(), faker.name().fullName(), faker.number().numberBetween(18, 60), faker.internet().emailAddress());
    }
}
