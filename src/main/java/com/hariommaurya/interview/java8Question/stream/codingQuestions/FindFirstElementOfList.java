package com.hariommaurya.interview.java8Question.stream.codingQuestions;

import java.util.Arrays;
import java.util.List;

public class FindFirstElementOfList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        list.stream()
                .findFirst().ifPresent(System.out::println);
    }
}
