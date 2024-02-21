package com.hariommaurya.interview.java8Question.stream.codingQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Java8Concatenation {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Java","8");
        List<String> list2 = Arrays.asList("Hariom","Maurya");
        Stream<String> stringStream  = Stream.concat(list1.stream(),list2.stream());
        stringStream.forEach(System.out::println);
    }
}
