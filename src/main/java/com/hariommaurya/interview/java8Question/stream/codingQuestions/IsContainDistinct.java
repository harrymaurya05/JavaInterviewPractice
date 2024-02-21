package com.hariommaurya.interview.java8Question.stream.codingQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class IsContainDistinct {
    public static void main(String[] args) {
        int arr[] = {1,2,2,4,5};
        List<Integer> list = Arrays
                            .stream(arr)
                            .boxed()
                .collect(Collectors.toList());
        HashSet<Integer> set = new HashSet<>(list);
        if(set.size() == list.size()) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }
}
