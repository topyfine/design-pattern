package com.topyfine.designpattern.command;

import org.junit.Test;

/**
 * @author 杨帆
 * @date 2018/11/12 10:32
 * @desc 1. 命令模式是通过命令发送者和命令执行者的解耦来完成对命令的具体控制的。
 * 2. 命令模式是对功能方法的抽象，并不是对对象的抽象。
 */
public class CommandTest {
    @Test
    public void testCommand() {
        // 命令的实际执行者
        Reciever reciever = new Reciever();
        // 命令包装实际执行行为
        ConcreteCommand command = new ConcreteCommand(reciever);
        // 命令有时可以直接完成receiver的事情
        command.execute();
        // 使用命令对象的入口
        // 命令的请求者，是命令模式中最重要的角色。
        // 这个角色用来对各个命令进行控制。
        // 引入中间层command，实现invoker和receiver的解耦。
        Invoker invoker = new Invoker();
        // 可以添加一系列的命令
        invoker.add(command);
        invoker.add(command);
        invoker.action();
    }
}
