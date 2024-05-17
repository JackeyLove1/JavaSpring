package com.example.helloworld.threads;

public class MyWaitAndNotify {
    static private final Object lock = new Object();

    static public class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("ThreadA is running");
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println("ThreadA " + i);
                        lock.notify();
                        ;
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("ThreadA is done");
                lock.notify();
            }
        }
    }

    static public class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("ThreadB is running");
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println("ThreadB " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("ThreadB is done");
                lock.notify();
            }
        }
    }
}
