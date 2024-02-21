package com.hariommaurya.interview.basic;

import java.util.Hashtable;

public class EqualAndHashCode {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("hariom");
        s1.setRollNo(1);
        Student s2 = new Student();
        s2.setName("Kiran");
        s2.setRollNo(1);
        System.out.println("Shallow Comparison : "+ (s1 == s2));
        System.out.println("Deep Comparison : "+s1.equals(s2));
    }
}
