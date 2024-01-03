package com.hariommaurya.interview.java8Question.stream.codingQuestions;

import com.hariommaurya.interview.basic.Student;

import java.util.*;

public class NullCheckAndIterator {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student(1,"Hariom"));
        studentList.add(new Student(2,"Maurya"));
        studentList.add(new Student(3,"Anu"));
        studentList.add(new Student(4,"Kiran"));
        Optional.ofNullable(studentList)
                .orElseGet(Collections::emptyList)
                .stream().filter(Objects::nonNull)
                .forEach(student -> System.out.println(student.getName()));

    }
}
