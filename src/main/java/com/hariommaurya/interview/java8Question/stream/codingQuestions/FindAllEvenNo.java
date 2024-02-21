package com.hariommaurya.interview.java8Question.stream.codingQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindAllEvenNo {
    public static void main(String[] args) {
            List<Integer> list = Arrays.asList(1,2,3,4,5,6);
            List<Integer> list1 = list.stream()
                    .filter(n -> n % 2 == 0)
                    .collect(Collectors.toList());
        System.out.println(list1);
    }
}
