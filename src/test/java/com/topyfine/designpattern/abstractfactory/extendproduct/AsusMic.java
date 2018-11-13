package com.topyfine.designpattern.abstractfactory.extendproduct;

/**
 * @author 杨帆
 * @date 2018/11/13 15:21
 * @desc v1.0.0
 */
public class AsusMic implements Mic {
    @Override
    public void sayHi() {
        System.out.println(">>> ASUS mic...");
    }
}
