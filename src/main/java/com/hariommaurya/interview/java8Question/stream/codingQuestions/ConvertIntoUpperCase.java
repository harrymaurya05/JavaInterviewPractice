package com.hariommaurya.interview.java8Question.stream.codingQuestions;

import java.util.Arrays;
import java.util.List;

public class ConvertIntoUpperCase {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hariom","maurya");
        list.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
