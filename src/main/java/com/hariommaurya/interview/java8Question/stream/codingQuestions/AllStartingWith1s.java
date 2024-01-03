package com.hariommaurya.interview.java8Question.stream.codingQuestions;

import java.util.Arrays;
import java.util.List;

public class AllStartingWith1s {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,11,12,24,52);
        list.stream()
                .map(n -> n + "")
                .filter(n -> n.startsWith("1"))
                .forEach(System.out::println);
    }
}
