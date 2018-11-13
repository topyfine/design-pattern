package com.topyfine.designpattern.abstractfactory;

/**
 * @author 杨帆
 * @date 2018/11/13 14:44
 * @desc 具体的工厂
 */
public class AsusPcFactory implements PcFactory {
    @Override
    public Mouse createMouse() {
        return new AsusMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new AsusKeyboard();
    }
}
