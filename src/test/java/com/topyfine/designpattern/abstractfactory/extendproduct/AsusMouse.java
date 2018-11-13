package com.topyfine.designpattern.abstractfactory.extendproduct;

/**
 * @author 杨帆
 * @date 2018/11/13 14:45
 * @desc v1.0.0
 */
public class AsusMouse implements Mouse {
    @Override
    public void sayHi() {
        System.out.println(">>> ASUS mouse...");
    }
}
