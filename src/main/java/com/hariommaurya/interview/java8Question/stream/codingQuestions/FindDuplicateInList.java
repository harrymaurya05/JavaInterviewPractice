package com.hariommaurya.interview.java8Question.stream.codingQuestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateInList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,2,4,4,6);
        Map<Integer,Long> result = list.stream()
                .filter(n ->Collections.frequency(list,n) > 1)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
        System.out.println(result);

    }
}
