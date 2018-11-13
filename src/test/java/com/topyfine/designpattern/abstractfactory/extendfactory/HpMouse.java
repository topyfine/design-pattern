package com.topyfine.designpattern.abstractfactory.extendfactory;

import com.topyfine.designpattern.abstractfactory.Mouse;

/**
 * @author 杨帆
 * @date 2018/11/13 14:53
 * @desc v1.0.0
 */
public class HpMouse implements Mouse {
    @Override
    public void sayHi() {
        System.out.println(">>> HP mouse...");
    }
}
