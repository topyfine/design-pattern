package com.topyfine.designpattern.command;

/**
 * @author 杨帆
 * @date 2018/11/12 10:29
 * @desc v1.0.0
 */
public class ConcreteCommand implements Command {
    private Reciever reciever;

    public ConcreteCommand(Reciever reciever) {
        this.reciever = reciever;
    }

    @Override
    public void execute() {
        reciever.doSomething();
    }
}
