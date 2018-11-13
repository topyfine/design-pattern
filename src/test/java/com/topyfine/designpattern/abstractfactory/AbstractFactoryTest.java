package com.topyfine.designpattern.abstractfactory;

import com.topyfine.designpattern.abstractfactory.extendfactory.HpPcFactory;
import org.junit.Test;

/**
 * @author 杨帆
 * @date 2018/11/13 14:49
 * @desc v1.0.0
 */
public class AbstractFactoryTest {
    @Test
    public void testAbstractFactory() {
        // 抽象工厂模式：具有多个产品线
        // 如果只有一类产品时，则可视为工厂模式
        PcFactory factory = new AsusPcFactory();
        factory.createKeyboard().sayHi();
        factory.createMouse().sayHi();
        // 扩展工厂
        // 只需扩展相应产品，无需更新已有的工厂
        PcFactory factory1 = new HpPcFactory();
        factory.createKeyboard().sayHi();
        factory.createMouse().sayHi();
    }
}
