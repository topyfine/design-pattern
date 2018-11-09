package com.topyfine.designpattern.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 杨帆
 * @date 2018/11/8 15:54
 * @desc 饿汉式单例模式 v1.0.0
 */
public class HungrySingleton {
    /**
     * 声明域时，便进行初始化
     */
    private static final HungrySingleton INSTANCE = new HungrySingleton();
    /**
     * 构造方法私有化。不允许外部创建
     */
    private HungrySingleton(){}

    /**
     * 暴露外部访问实例对象方法
     *
     * @return 单例对象
     */
    public static HungrySingleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        HungrySingleton singleton = getInstance();
        // 启用多个线程测试实例引用是否相同
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Runnable task = () -> {
            HungrySingleton instance = getInstance();
            System.out.println(instance);
            System.out.println(instance == singleton);
        };
        // 开启n个线程
        for (int i = 0; i < 100; i++) {
            pool.submit(task);
        }
        pool.shutdown();
    }
}
