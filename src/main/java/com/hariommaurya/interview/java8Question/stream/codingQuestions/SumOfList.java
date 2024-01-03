package com.hariommaurya.interview.java8Question.stream.codingQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumOfList {
    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,4,5,6);
        Integer sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
        sum = list.stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.println(sum);
        sum = list.stream().reduce(0,(a,b) -> a+b);
        System.out.println(sum);
        sum = list.stream().reduce(0,Integer::sum);
        System.out.println(sum);
        sum = list.stream().reduce(0,SumOfList::add);
    }
}
