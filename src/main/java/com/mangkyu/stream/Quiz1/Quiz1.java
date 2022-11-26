package com.mangkyu.stream.Quiz1;

import com.opencsv.CSVReader;
import org.apache.commons.lang3.StringUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Quiz1 {

    public Map<String, Integer> quiz1() throws IOException {

        CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));
        //readNext로 text를 공백 단위로 string 배열 요소에 담김, readNext는 개행 단위로 string을 읽는다.
        csvReader.readNext();
        //개행 단위로  String[]을 만듬
        List<String[]> csvLines = csvReader.readAll();

        return csvLines.stream()
                .map(x -> {
                    return (x[1].trim().split(":"));
                }).flatMap(x -> {
                    return (Arrays.stream(x));
                }).collect(Collectors.toMap(hobby -> hobby, hobby -> 1, (oldValue, newValue) -> newValue += oldValue));

    }

    public Map<String, Integer> quiz2() throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));
        csvReader.readNext();
        List<String[]> strings = csvReader.readAll();
        //filter를 먼저 한다. 그 이후
        return strings.stream()
                .filter((x) -> {
                    return x[0].startsWith("정");
                }).map( x -> {
                    return (x[1].trim().split(":"));
                }).flatMap( x -> {
                    return (Arrays.stream(x));
                }).collect(Collectors.toMap(hobby -> hobby, hobby ->1, (oldValue, newValue) -> newValue += oldValue));


    }

    public int quiz3() throws IOException {

        CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));
        csvReader.readNext();

        return   csvReader.readAll()
                .stream()
                .map( (x) -> {
                    return StringUtils.countMatches(x[2], "좋아");
                }).reduce( 0, Integer::sum);
    }

    private List<String[]> readCsvLines() throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));
        csvReader.readNext();
        return csvReader.readAll();
    }

    String X = "좋아";

    int countContains( String txt, int index) {

        int findIndex = txt.indexOf("좋아", index);
        if (findIndex >= 0) {
            return 1 + countContains(txt, findIndex + X.length());
        }
        return 0;
    }

    public static void main(String[] args)  {

        try {
           new Quiz1().quiz3();
        } catch (IOException exception){

        }

    }

}
