package com.example.helloworld.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class MyConsumer implements Runnable {
    private BlockingQueue<Integer> queue;

    public MyConsumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int value = queue.take();
                if (value == -1){
                    break;
                }
                System.out.println("Consumer: " + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
