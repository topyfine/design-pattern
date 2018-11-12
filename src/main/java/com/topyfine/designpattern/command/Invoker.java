package com.topyfine.designpattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 杨帆
 * @date 2018/11/12 10:28
 * @desc v1.0.0
 */
public class Invoker {
    private List<Command> commands = new ArrayList<>();

    public void add(Command command) {
        commands.add(command);
    }

    public void action() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
