package com.topyfine.designpattern.factory;

/**
 * @author shipfly
 * @version V1.0
 * @date 2018/11/10 14:26
 */
public class Car implements ICar {
    private String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    @Override
    public void driver() {
        System.out.println(brand + " run...");
    }
}
