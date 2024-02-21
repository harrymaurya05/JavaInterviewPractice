package com.hariommaurya.interview.java8Question.stream.codingQuestions;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class SortArrayConvertStream {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        Arrays.parallelSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
