package com.topyfine.designpattern.abstractfactory.extendfactory;

import com.topyfine.designpattern.abstractfactory.Keyboard;

/**
 * @author 杨帆
 * @date 2018/11/13 14:54
 * @desc v1.0.0
 */
public class HpKeyboard implements Keyboard {
    @Override
    public void sayHi() {
        System.out.println(">>> HP keyboard...");
    }
}
