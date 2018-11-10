package com.topyfine.designpattern.singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

/**
 * @author 杨帆
 * @date 2018/11/8 16:18
 * @desc 懒汉式单例 v1.0.0
 */
public class LazySingleton {
    /**
     * 单例引用
     */
    private static LazySingleton instance;

    /**
     * 构造方法私有化。不允许外部构造
     */
    private LazySingleton() {
    }

    /**
     * 暴露访问单例对象的方法。
     * 非线程安全。
     *
     * @return 单例
     */
    public static LazySingleton getInstance() {
        if (instance == null) {
            try {
                System.out.println("[非线程安全]" + Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 暴露访问单例对象的方法。
     * 线程安全。
     *
     * @return 单例
     */
    public static synchronized LazySingleton getInstance2() {
        if (instance == null) {
            try {
                System.out.println("[线程安全]" + Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new LazySingleton();
        }
        return instance;
    }

    public static void main(String[] args) throws InterruptedException {
        int taskNum = 1000 * 1000;
        // 首先验证非线程安全的方法
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 5,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2 * taskNum), Executors.defaultThreadFactory());

        // 非线程安全
        List<String> list = Collections.synchronizedList(new ArrayList<>(taskNum));
        CountDownLatch latch = new CountDownLatch(taskNum);
        Runnable task = () -> {
            LazySingleton instance = getInstance();
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

        // 线程安全
        /*List<String> list2 = Collections.synchronizedList(new ArrayList<>(taskNum));
        CountDownLatch latch2 = new CountDownLatch(taskNum);
        Runnable task2 = () -> {
            LazySingleton instance = getInstance2();
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
        }*/

        pool.shutdown();
    }
}
