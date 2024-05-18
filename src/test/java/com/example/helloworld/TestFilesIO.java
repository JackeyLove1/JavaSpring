package com.example.helloworld;

import com.example.helloworld.threads.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.*;

@SpringBootTest
public class TestFilesIO {
    @Test
    public void TestThreadBasic() {
        var t1 = new MyThread();
        var t2 = new MyThread();
        t1.start();
        t2.start();
    }

    @Test
    public void TestRunnable() {
        var t1 = new Thread(new MyRunnable());
        var t2 = new Thread(new MyRunnable());
        t1.start();
        t2.start();
    }

    @Test
    public void TestLambdaThread() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        }).start();
    }

    @Test
    public void TestThreadFuture() {
        ExecutorService service = Executors.newFixedThreadPool(2);
        var future1 = service.submit(new MyCallable());
        var future2 = service.submit(new MyCallable());
        try {
            System.out.println("Result from thread 1: " + future1.get());
            System.out.println("Result from thread 2: " + future2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }

    @Test
    public void TestThreadPool() {
        var counter = new MyCounter();
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++){
                counter.increment();
            }
        };
        for (int i = 0; i < 10; i++){
            pool.execute(task);
        }
        pool.shutdown();
        try {
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
        }
        System.out.println(counter.getCount());
    }

    @Test
    public void TestThreadCountDownLatch() {
        var counter = new MyCounter();
        var CountDownLatch = new CountDownLatch(10);
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++){
                counter.increment();
            }
            CountDownLatch.countDown();
        };
        for (int i = 0; i < 10; i++){
            pool.execute(task);
        }
        pool.shutdown();
        try {
            CountDownLatch.await();
        } catch (InterruptedException e) {
            pool.shutdownNow();
        }
        System.out.println(counter.getCount());
    }


    @Test
    public void TestThreadLock() {
        var counter = new MyLockCounter();
        var CountDownLatch = new CountDownLatch(10);
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++){
                counter.increment();
            }
            CountDownLatch.countDown();
        };
        for (int i = 0; i < 10; i++){
            pool.execute(task);
        }
        pool.shutdown();
        try {
            CountDownLatch.await();
        } catch (InterruptedException e) {
            pool.shutdownNow();
        }
        System.out.println(counter.getCount());
    }


    @Test
    public void TestThreadProducerConsumer() throws InterruptedException {
        var queue = new ArrayBlockingQueue<Integer>(10) {};
        var producer = new MyProducer(queue);
        var consumer = new MyConsumer(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
        Thread.sleep(1000);
    }

    @BeforeEach
    public void setup() {
        System.out.println("Setup");
    }

    @AfterEach
    public void teardown() {
        System.out.println("Teardown");
    }
}
