package com.topyfine.designpattern.factory;

import org.junit.Test;

/**
 * @author shipfly
 * @version V1.0
 * @date 2018/11/10 14:33
 */
public class FactoryTest {

    @Test
    public void testFactory() {
        // 想买车就去找汽车工厂
        ICarFactory factory = new CarFactory();
        // 告诉工厂给我台车
        ICar car = factory.newCar("BUICK");
        // 开起来试车
        car.driver();
    }

    @Test
    public void testSimpleFactory() {
        // 此方法减弱了工厂方式的扩展能力
        ICar car = SimpleCarFactory.newCar("AUDI");
        car.driver();
    }
}
