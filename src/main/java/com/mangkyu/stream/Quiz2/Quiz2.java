package com.mangkyu.stream.Quiz2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Quiz2 {

    private static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    public Map<String, Integer> quiz1() {


        return WORDS.stream()
                .map(str -> {
                    return str.substring(0,1);
                }).collect(Collectors.toMap((str) -> {
                    return str;
                    }, (value) -> {
                        return 1;
                    }, (oldValue, newValue) -> {
                    System.out.println( oldValue + ", " + newValue);
                        return newValue += oldValue;
                    })
                );
    }

    public String quiz2() {

        return WORDS.stream()
                .filter( str -> {
                    return str.length() >= 2;
                }).map( String::toUpperCase)
                .map( str -> {
                    return str.substring(0, 1);
                }).collect(Collectors.joining(" "));

    }

    public static void main(String[] args) {
        new Quiz2().quiz1();
    }

}
