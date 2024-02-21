package com.hariommaurya.interview.java8Question.stream.codingQuestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountFreqOfCharInString {
    public static void main(String[] args) {
        String str = "Hariom and kiran both are working professional.";
        Map<Character,Long> map = str.chars()
                .mapToObj(c -> (char)c)
                .filter(character -> (character != ' ' || character !='.'))
                .collect(Collectors.toList())
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));
        System.out.println(map);
    }
}
