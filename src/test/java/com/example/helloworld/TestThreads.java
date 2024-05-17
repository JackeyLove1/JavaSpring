package com.example.helloworld;

import com.example.helloworld.threads.MyWaitAndNotify;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@SpringBootTest
public class TestThreads {
    @Test
    public void TestObjectLock() throws InterruptedException {
        new Thread(new MyWaitAndNotify.ThreadA()).start();
        Thread.sleep(100);
        new Thread(new MyWaitAndNotify.ThreadB()).start();
    }

    @Test
    public void TestAtomicBasic() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        final int threads = 10, counts = 10000;
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            new Thread(() -> {
                for (int j = 0; j < counts; j++) {
                    atomicInteger.incrementAndGet();
                }
                countDownLatch.countDown();
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(atomicInteger.get());
        Assertions.assertEquals(atomicInteger.get(), threads * counts);

    }

    @Test
    public void TestLockFreeQueue() {
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        AtomicInteger count = new AtomicInteger(0);
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                count.incrementAndGet();
                queue.add(i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
            count.decrementAndGet();
        }
        Assertions.assertEquals(count.get(), 0);
    }

    @Test
    public void TestVirtualThread() {
        ExecutorService pool = Executors.newVirtualThreadPerTaskExecutor();
        final int thread = 10000, counts = 1000;
        CountDownLatch countDownLatch = new CountDownLatch(thread);
        for (int i = 0; i < thread; i++) {
            pool.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            countDownLatch.countDown();
        }
        pool.shutdown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestSemaphore() {
        Semaphore semaphore = new Semaphore(5);
        final int threads = 10;
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName());
                    Random random = new Random();
                    Thread.sleep(random.nextInt(200));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    countDownLatch.countDown();
                }
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestStreamParallel() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).parallel().reduce((a, b) -> {
            System.out.println(Thread.currentThread().getName());
            return a + b;
        }).ifPresent(System.out::println);
    }

    @Test
    public void TestScheduledExecutor() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(System.currentTimeMillis());
                    }
                }, 0, 1, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(() -> {
            System.out.println("Shutting down schedule ...");
            scheduledExecutorService.shutdown();
            try {
                scheduledExecutorService.awaitTermination(1, TimeUnit.SECONDS);
            }catch (InterruptedException e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }, 5, TimeUnit.SECONDS);

    }
}
