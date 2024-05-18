package com.example.helloworld.pojo;

public class User {
    private String name;
    private Integer age;
    private Address address;

    @Override
    public String toString() {
        return "User{" +
                "address=" + address +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public User() {
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public User(int age, String name, Address address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
