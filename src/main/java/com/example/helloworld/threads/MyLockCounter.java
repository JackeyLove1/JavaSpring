package com.example.helloworld.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLockCounter {
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    public int getCount() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }

    public void setCount(int count) {
        lock.lock();
        try {
            this.count = count;
        } finally {
            lock.unlock();
        }
    }

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            count--;
        } finally {
            lock.unlock();
        }
    }
}
