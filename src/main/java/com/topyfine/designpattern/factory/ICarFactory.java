package com.topyfine.designpattern.factory;

/**
 * @author shipfly
 * @version V1.0
 * @date 2018/11/10 14:16
 */
public interface ICarFactory {
    /**
     * give me a car
     *
     * @param brand 品牌
     * @return
     */
    ICar newCar(String brand);
}
