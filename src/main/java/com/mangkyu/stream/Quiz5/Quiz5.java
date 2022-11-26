package com.mangkyu.stream.Quiz5;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Quiz5 {

    private static final String[] STRING_ARR = {"aaa", "bb", "c", "dddd"};

    public int quiz1() {
        return Arrays.stream(STRING_ARR)
                .mapToInt( str -> {
                    return str.length();
                })
                .sum();
    }

    public int quiz2() {
        return Arrays.stream(STRING_ARR)
                .mapToInt( str -> {
                    return str.length();
                }).max()
                .orElse(0);
    }

    public List<Integer> quiz3() {
        return new Random().ints(1, 46)
                .distinct()
                .limit(6)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

    }


    public List<Integer[]> quiz4() {
        return IntStream.rangeClosed(1, 6)
                .boxed()
                .flatMap( (diceNum1) -> {
                    return IntStream.rangeClosed(1, 6)
                            .boxed()
                            .map( (diceNum2) -> {
                               return new Integer[]{diceNum1, diceNum2};
                            });
                })
                .filter( (dicePair -> {
                    return dicePair[0] + dicePair[1] == 6;
                }) )
                .collect(Collectors.toList());

    }

    public static void main(String[] args) {
        new Quiz5().quiz3();
    }

}
