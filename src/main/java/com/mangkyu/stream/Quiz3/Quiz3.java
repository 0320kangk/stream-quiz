package com.mangkyu.stream.Quiz3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Quiz3 {

    private static final List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    private static final List<Integer> numbers2 = Arrays.asList(3, 4);

    public List<Integer[]> quiz1() {

        return numbers1.stream()
                .flatMap( (num1) -> numbers2.stream().map(num2 -> {
                    return new Integer[]{num1, num2};
                })).collect(Collectors.toList());

    }

    public int quiz2() {
        return numbers1.stream()
                .flatMap( (num1) -> numbers2.stream().map(num2 -> {
                    return new Integer[]{num1, num2};
                })).mapToInt( (numArray) -> {
                    return numArray[0] * numArray[1];
                }).max().orElse(0);

    }

}
