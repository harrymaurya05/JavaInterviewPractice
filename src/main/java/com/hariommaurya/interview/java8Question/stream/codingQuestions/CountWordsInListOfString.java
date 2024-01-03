package com.hariommaurya.interview.java8Question.stream.codingQuestions;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountWordsInListOfString {
    public static void main(String[] args) {
        String str = "dddaazgzeecc";
        Map<Character,Long> map = str.chars().mapToObj(c ->(char) c).collect(Collectors.toList()).stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));
        System.out.println(map.entrySet().stream().map((entry) -> //stream each entry, map it to string value
                        "" + entry.getKey() + "" + entry.getValue()+ "")
                .collect(Collectors.joining("")));
    }
}
