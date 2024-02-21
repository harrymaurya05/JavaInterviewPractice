package com.hariommaurya.interview.java8Question.stream.codingQuestions;

import java.util.Arrays;
import java.util.List;

public class SortList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,4,8,1,23,29,10);
        list.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
