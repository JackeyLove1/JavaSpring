package com.example.helloworld;

import java.io.Serializable;

public class Phone implements Serializable {
    private String brand;
    private String memory;
    private double price;
    private boolean used;

    /**
     * 构造方法
     *
     * @param brand
     * @param memory
     * @param price
     */
    public Phone(String brand, String memory, double price) {
        this.brand = brand;
        this.memory = memory;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}
