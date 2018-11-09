package com.topyfine.designpattern.singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
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
        System.out.println("[线程安全][线程尝试进入...]" + Thread.currentThread().getName());
        if (instance == null) {
            try {
                System.out.println("[线程安全][进入成功]" + Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new LazySingleton();
        }
        return instance;
    }

    public static void main(String[] args) {

        List<String> list = Collections.synchronizedList(new ArrayList<>(100));
        // 首先验证非线程安全的方法
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 5,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(90), Executors.defaultThreadFactory());
        // 非线程安全
        Runnable task = () -> {
            LazySingleton instance = getInstance();
            System.out.println(instance);
            list.add(instance.toString());
        };
        /*for (int i = 0; i < 100; i++) {
            pool.execute(task);
        }*/
        // 查看实例是否唯一
        /*System.out.println(list.size());
        long count = Stream.of(list).distinct().count();
        System.out.println(count);*/

        // 线程安全
        Runnable task2 = () -> {
            LazySingleton instance = getInstance2();
            System.out.println(instance);
        };
        for (int i = 0; i < 100; i++) {
            pool.execute(task2);
        }
        pool.shutdown();
    }
}
