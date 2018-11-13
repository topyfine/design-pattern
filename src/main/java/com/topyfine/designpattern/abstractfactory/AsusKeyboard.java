package com.topyfine.designpattern.abstractfactory;

/**
 * @author 杨帆
 * @date 2018/11/13 14:46
 * @desc v1.0.0
 */
public class AsusKeyboard implements Keyboard {
    @Override
    public void sayHi() {
        System.out.println(">>> ASUS keyboard...");
    }
}
