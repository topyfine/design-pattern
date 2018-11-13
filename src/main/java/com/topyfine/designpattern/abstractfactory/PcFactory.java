package com.topyfine.designpattern.abstractfactory;

/**
 * @author 杨帆
 * @date 2018/11/13 14:41
 * @desc 1个工厂具有多个产品线
 */
public interface PcFactory {
    Mouse createMouse();

    Keyboard createKeyboard();
}
