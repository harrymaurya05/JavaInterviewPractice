package com.hariommaurya.interview.java8Question.stream.codingQuestions;

import java.util.Arrays;
import java.util.List;

public class FindMaxElement {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(11,23,14,15,87,100);
        int max = list.stream()
                .max(Integer::compare)
                .get();
        System.out.println(max);

    }
}
