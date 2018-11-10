package com.topyfine.designpattern.singleton;

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
                System.out.println("[非线程安全]进入创建区域..." + Thread.currentThread().getName());
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
                System.out.println("[线程安全]进入创建区域" + Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new LazySingleton();
        }
        return instance;
    }
}
