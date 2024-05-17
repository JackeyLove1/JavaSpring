package com.example.helloworld.threads;

public class MyCounter {
    private int count = 0;

    public synchronized int getCount() {
        return count;
    }

    public synchronized void setCount(int count) {
        this.count = count;
    }

    public synchronized void increment(){
        count++;
    }

    public synchronized void decrement(){
        count--;
    }


}
