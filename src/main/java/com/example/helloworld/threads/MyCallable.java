package com.example.helloworld.threads;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().threadId() + " myCallable.call()");
        return 1;
    }
}
