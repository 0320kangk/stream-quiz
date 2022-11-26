package com.mangkyu.stream.Quiz6;

import com.mangkyu.stream.Quiz5.Quiz5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Quiz6 {

    private Student[] stuArr;

    public Quiz6() {
        init();
    }

    public Map<Boolean, List<Student>> quiz1() {
        return Arrays.stream(stuArr)
                .filter( student -> {
                    return student.getScore() < 150;
                })
                .collect(Collectors.groupingBy(Student::isMale));
    }

    public Map<Integer, Map<Integer, Integer>> quiz2() {

        /**
         * 1. groupingBy를 통해 학년으로 학생들을 묶는다.
         * 2. groupingBy를 한번 더 하여 반 별로 묶는다.
         * 3. 묶은 학생들의 점수를 합한다.
         */
        return Arrays.stream(stuArr)
                .collect(Collectors.groupingBy( Student::getHak,
                        Collectors.groupingBy( Student::getBan, Collectors.summingInt( Student::getScore))));

    }

    private void init() {
        stuArr = new Student[]{
                new Student("나자바", true, 1, 1, 300),
                new Student("김지미", false, 1, 1, 250),
                new Student("김자바", true, 1, 1, 200),
                new Student("이지미", false, 1, 2, 150),
                new Student("남자바", true, 1, 2, 100),
                new Student("안지미", false, 1, 2, 50),
                new Student("황지미", false, 1, 3, 100),
                new Student("강지미", false, 1, 3, 150),
                new Student("이자바", true, 1, 3, 200),
                new Student("나자바", true, 2, 1, 300),
                new Student("김지미", false, 2, 1, 250),
                new Student("김자바", true, 2, 1, 200),
                new Student("이지미", false, 2, 2, 150),
                new Student("남자바", true, 2, 2, 100),
                new Student("안지미", false, 2, 2, 50),
                new Student("황지미", false, 2, 3, 100),
                new Student("강지미", false, 2, 3, 150),
                new Student("이자바", true, 2, 3, 200)
        };

    }

    public static void main(String[] args) {
        new Quiz6().quiz2();
    }

}
