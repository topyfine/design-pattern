package com.topyfine.designpattern.factory;

/**
 * @author shipfly
 * @version V1.0
 * @date 2018/11/10 14:22
 */
public class CarFactory implements ICarFactory {
    @Override
    public ICar newCar(String brand) {
        // 造车
        return new Car(brand);
    }
}
