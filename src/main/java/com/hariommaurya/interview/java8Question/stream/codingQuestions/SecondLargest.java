package com.hariommaurya.interview.java8Question.stream.codingQuestions;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondLargest {
    public static void main(String[] args) {
        /*Find Second-largest element in list*/
        List<Integer> arr = Arrays.asList(3,1,2,7,8,10);
        LocalTime start = LocalTime.now();
        System.out.println(arr.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get());
        LocalTime end = LocalTime.now();
        Duration duration =  Duration.between(start,end);
        System.out.println(duration.getNano());
    }
}
