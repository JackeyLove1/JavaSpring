package com.example.helloworld.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyProducer implements Runnable {
    private BlockingQueue<Integer> queue;

    public MyProducer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                queue.put(i);
                System.out.println("Produced: " + i);
            }
            queue.put(-1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
