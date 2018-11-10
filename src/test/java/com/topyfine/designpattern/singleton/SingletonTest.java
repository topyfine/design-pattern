package com.topyfine.designpattern.singleton;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

/**
 * @author shipfly
 * @version V1.0
 * @date 2018/11/10 14:42
 */
public class SingletonTest {
    @Test
    public void testHungrySingleton() {
        HungrySingleton singleton = HungrySingleton.getInstance();
        // 启用多个线程测试实例引用是否相同
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Runnable task = () -> {
            HungrySingleton instance = HungrySingleton.getInstance();
            System.out.println(instance);
            System.out.println(instance == singleton);
        };
        // 开启n个线程
        for (int i = 0; i < 100; i++) {
            pool.submit(task);
        }
        pool.shutdown();
    }

    @Test
    public void testLazySingleton() throws InterruptedException {
        int taskNum = 1000 * 1000;
        // 首先验证非线程安全的方法
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 5,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(taskNum), Executors.defaultThreadFactory());

        // 非线程安全
        List<String> list = Collections.synchronizedList(new ArrayList<>(taskNum));
        CountDownLatch latch = new CountDownLatch(taskNum);
        Runnable task = () -> {
            LazySingleton instance = LazySingleton.getInstance();
//            System.out.println(instance);
            list.add(instance.toString());
            latch.countDown();
        };
        for (int i = 0; i < taskNum; i++) {
            pool.execute(task);
        }
        // 线程阻塞于此，等待所有线程完成
        latch.await();
        // 查看实例是否唯一
        System.out.println(list.size());
        long count = Stream.of(list.toArray()).distinct().count();
        System.out.println(count);
        if (count > 1) {
            System.err.println("[非线程安全]单例不唯一");
        }

        pool.shutdown();
    }

    @Test
    public void testLazySingleton2() throws InterruptedException {
        int taskNum = 1000 * 1000;
        // 首先验证非线程安全的方法
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 5,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(taskNum), Executors.defaultThreadFactory());

        // 线程安全
        List<String> list2 = Collections.synchronizedList(new ArrayList<>(taskNum));
        CountDownLatch latch2 = new CountDownLatch(taskNum);
        Runnable task2 = () -> {
            LazySingleton instance = LazySingleton.getInstance2();
//            System.out.println(instance);
            list2.add(instance.toString());
            latch2.countDown();
        };
        for (int i = 0; i < taskNum; i++) {
            pool.execute(task2);
        }
        // 线程阻塞于此，等待所有线程完成
        latch2.await();
        // 查看实例是否唯一
        System.out.println(list2.size());
        long count2 = Stream.of(list2.toArray()).distinct().count();
        System.out.println(count2);
        if (count2 > 1) {
            System.err.println("[线程安全]单例不唯一");
        }

        pool.shutdown();
    }
}
