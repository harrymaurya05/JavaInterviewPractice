package com.hariommaurya.interview.java8Question.stream.codingQuestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateAndCount {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String,Long> map = names.stream()
                .filter(str -> Collections.frequency(names,str) > 1)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map);
    }
}
