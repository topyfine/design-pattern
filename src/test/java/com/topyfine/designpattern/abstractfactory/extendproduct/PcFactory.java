package com.topyfine.designpattern.abstractfactory.extendproduct;

/**
 * @author 杨帆
 * @date 2018/11/13 14:41
 * @desc 1个工厂具有多个产品线
 */
public interface PcFactory {
    Mouse createMouse();

    Keyboard createKeyboard();

    // 新扩展产品线时
    // 所有已存在的工厂都需实现新产品的生产
    // default 出现可解决此问题
    // default Mic createMic() {return null;}
    Mic createMic();
}
