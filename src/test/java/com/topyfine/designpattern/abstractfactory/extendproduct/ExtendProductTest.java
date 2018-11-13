package com.topyfine.designpattern.abstractfactory.extendproduct;

import org.junit.Test;

/**
 * @author 杨帆
 * @date 2018/11/13 15:26
 * @desc v1.0.0
 */
public class ExtendProductTest {
    @Test
    public void testExtendProduct() {
        PcFactory factory = new AsusPcFactory();
        factory.createKeyboard().sayHi();
        factory.createMouse().sayHi();
        factory.createMic().sayHi();
    }
}
