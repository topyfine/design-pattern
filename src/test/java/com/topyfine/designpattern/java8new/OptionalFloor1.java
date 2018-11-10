package com.topyfine.designpattern.java8new;

import java.util.Optional;

/**
 * @author shipfly
 * @version V1.0
 * @date 2018/11/10 21:42
 */
public class OptionalFloor1 {
    public Optional<OptionalFloor2> m1() {
        System.out.println(this.getClass().getName() + " >>> m1");
        return Optional.of(new OptionalFloor2());
    }
}
