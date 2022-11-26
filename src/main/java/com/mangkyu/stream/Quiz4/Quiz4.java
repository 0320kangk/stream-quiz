package com.mangkyu.stream.Quiz4;


import java.util.*;
import java.util.stream.Collectors;

public class Quiz4 {

    private List<Transaction> transactions;

    public Quiz4() {
        init();
    }

    private void init() {
        Trader kyu = new Trader("Kyu", "Seoul");
        Trader ming = new Trader("Ming", "Gyeonggi");
        Trader hyuk = new Trader("Hyuk", "Seoul");
        Trader hwan = new Trader("Hwan", "Busan");

        transactions = Arrays.asList(
                new Transaction(kyu, 2019, 30000),
                new Transaction(kyu, 2020, 12000),
                new Transaction(ming, 2020, 40000),
                new Transaction(ming, 2020, 7100),
                new Transaction(hyuk, 2019, 5900),
                new Transaction(hwan, 2020, 4900)
        );
    }
    public List<Transaction> quiz1() {

        return  transactions.stream()
                .filter( transaction -> {
                    return transaction.getYear() >= 2020;
                }).sorted(Comparator.comparing( (transaction -> {
                    return transaction.getValue();
                }))).collect(Collectors.toList());
    }

    public List<String> quiz2() {

        return transactions.stream()
                .map( transaction -> {
                    return transaction.getTrader().getCity();
                }).distinct()
                .collect(Collectors.toList());
    }

    public List<Trader> quiz3() {

        return transactions.stream()
                .filter( (transaction -> {
                    return transaction.getTrader().getCity().equals("Seoul");
                }))
                .map( Transaction::getTrader )
                .distinct()
                .sorted(Comparator.comparing( trader -> {
                    return trader.getName();
                } ) )
                .collect(Collectors.toList());

    }

    public String quiz4() {

        return transactions.stream()
                .map( transaction -> {
                    return transaction.getTrader().getName();
                })
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));
    }

    public boolean quiz5() {

        return transactions.stream()
                .anyMatch( transaction -> {
                    return transaction.getTrader().getCity().equals("Busan");
                });
    }

    public List<Integer> quiz6() {
        return transactions.stream()
                .filter( (transaction -> {
                    return transaction.getTrader().getCity().equals("Seoul");
                }))
                .map( transaction -> {
                    return transaction.getValue();
                })
                .collect(Collectors.toList());
    }

    public Integer[] quiz7() {

        Integer[] results = new Integer[2];
        results[0] = transactions.stream()
                .mapToInt(transaction -> transaction.getValue())
                .reduce(Integer::max).orElse(0);

        results[1]  = transactions.stream()
                .mapToInt(transaction -> transaction.getValue())
                .min().orElse(0);

        return results;
    }

    public static void main(String[] args) {
        new Quiz4().quiz3();
    }


}
