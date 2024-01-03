package com.hariommaurya.interview.java8Question.stream.codingQuestions;

import com.hariommaurya.interview.basic.Student;

import java.util.*;
import java.util.stream.Collectors;

public class ConvertIntoSortedMap {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student(1,"Hariom"));
        studentList.add(new Student(3,"Maurya"));
        studentList.add(new Student(3,"Anu"));
        studentList.add(new Student(2,"Kiran"));
        Map<Integer,String> studentMap = studentList.stream()
                .collect(Collectors.toMap(Student::getRollNo,Student::getName,(oldValue,newValue)->oldValue, LinkedHashMap::new));
        System.out.println(studentMap);
    }
}
