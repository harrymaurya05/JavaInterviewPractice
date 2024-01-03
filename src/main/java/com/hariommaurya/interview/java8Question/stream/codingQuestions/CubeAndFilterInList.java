package com.hariommaurya.interview.java8Question.stream.codingQuestions;

import java.util.Arrays;
import java.util.List;

public class CubeAndFilterInList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,5,6,7,1,2,3);
        list.stream()
                .map(n -> n * n * n)
                .filter(n -> n < 50)
                .forEach(System.out::println);
    }
}
