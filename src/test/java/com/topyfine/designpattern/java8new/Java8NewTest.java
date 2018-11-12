package com.topyfine.designpattern.java8new;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author shipfly
 * @version V1.0
 * @date 2018/11/10 21:15
 */
public class Java8NewTest {
    @Test
    public void testOptional() {
        Optional<Integer> optional = Optional.of(-2).map(Math::abs);
        System.out.println(optional.get());
        Optional<Integer> optional2 = Optional.of(-8)
                .flatMap(v -> v == null ? Optional.empty() : Optional.of(Math.abs(v)));
        System.out.println(optional2.get());

        // map vs flatMap
        Optional.of(new OptionalFloor1()).flatMap(OptionalFloor1::m1)
                .flatMap(OptionalFloor2::m2).ifPresent(OptionalFloor3::m3);
    }

    @Test
    public void testStream() {
        // 收集
        String collect = Stream.of(new String[]{"BMW", "AUDI", "BENZ"}).collect(Collectors.joining(","));
        System.out.println(collect);
        IntSummaryStatistics summaryStatistics = Stream.of(new Integer[]{2, 4, 8, 16})
                .collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(summaryStatistics.getAverage() + " -|--|- " + summaryStatistics.getCount()
                + " -|--|- " + summaryStatistics.getSum());
        // map key重复时，映射值使用默认策略：抛出illegalStateException
        /*Map<String, Locale> localeMap = Stream.of(Locale.getAvailableLocales())
                .collect(Collectors.toMap(Locale::getCountry, Function.identity()));*/
        // map key重复时，映射值使用custom lamda
        // 收集到映射结果
        Map<String, Locale> localeMap2 = Stream.of(Locale.getAvailableLocales())
                .collect(Collectors.toMap(Locale::getCountry, Function.identity(), (origin, newVal) -> {
                    System.out.println(origin + " --> " + newVal);
                    return newVal;
                }));
        TreeMap<String, Locale> treeMap = Stream.of(Locale.getAvailableLocales())
                .collect(Collectors.toMap(Locale::getCountry, Function.identity(), (origin, newVal) -> {
//                    System.out.println(origin + "," + newVal);
                    return newVal;
                }, TreeMap::new));
        // 聚集：群组&分区
        Map<String, List<Locale>> collect1 = Stream.of(Locale.getAvailableLocales())
                .collect(Collectors.groupingBy(Locale::getCountry));
        Map<String, Long> collect2 = Stream.of(Locale.getAvailableLocales())
                .collect(Collectors.groupingBy(Locale::getCountry, Collectors.counting()));
        // 聚集带下游处理器
        Map<String, Set<String>> collect3 = Stream.of(Locale.getAvailableLocales())
                .collect(Collectors.groupingBy(Locale::getCountry,
                Collectors.mapping(Locale::getDisplayLanguage, Collectors.toSet())));
        Map<String, Optional<String>> collect4 = Stream.of(Locale.getAvailableLocales())
                .collect(Collectors.groupingBy(Locale::getCountry,
                Collectors.mapping(Locale::getDisplayLanguage, Collectors.maxBy(Comparator.comparing(String::length)))));
        // 断言聚集
        Map<Boolean, List<Locale>> collect5 = Stream.of(Locale.getAvailableLocales())
                .collect(Collectors.partitioningBy((l) -> l.getDisplayLanguage().equals("中文")));
        Map<Boolean, Set<Locale>> collect6 = Stream.of(Locale.getAvailableLocales())
                .collect(Collectors.partitioningBy((l) -> l.getDisplayLanguage().equals("中文"), Collectors.toSet()));
        // 基本类型流
        OptionalInt anInt = IntStream.of(2, 4, 8, 16).reduce(Integer::sum);
        // [1,10)
        long count = IntStream.range(1, 10).boxed().count();
        // [1, 10]
        int[] ints = IntStream.rangeClosed(1, 10).toArray();
    }
}
