package com.topyfine.designpattern.factory;

/**
 * @author shipfly
 * @version V1.0
 * @date 2018/11/10 15:16
 */
public class SimpleCarFactory {
    /**
     * 简单工厂模式：使用类方法
     * @return
     */
    public static ICar newCar(String brand) {
        return new Car(brand);
    }
}
