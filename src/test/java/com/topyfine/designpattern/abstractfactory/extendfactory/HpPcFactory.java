package com.topyfine.designpattern.abstractfactory.extendfactory;

import com.topyfine.designpattern.abstractfactory.Keyboard;
import com.topyfine.designpattern.abstractfactory.Mouse;
import com.topyfine.designpattern.abstractfactory.PcFactory;

/**
 * @author 杨帆
 * @date 2018/11/13 14:53
 * @desc v1.0.0
 */
public class HpPcFactory implements PcFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new HpKeyboard();
    }
}
