package com.topyfine.designpattern.java8new;

import java.util.Optional;

/**
 * @author shipfly
 * @version V1.0
 * @date 2018/11/10 21:43
 */
public class OptionalFloor2 {
    public Optional<OptionalFloor3> m2() {
        System.out.println(this.getClass().getName() + " >>> m2");
        return Optional.of(new OptionalFloor3());
    }
}
