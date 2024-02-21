package com.hariommaurya.interview.designPattern.creational;


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Eployee{
    private String name;
    private Integer id;
    private Double salary;

    public Eployee() {
    }
    public Eployee(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setSalary(builder.salary);
    }


    public String name() {
        return name;
    }

    public Eployee setName(String name) {
        this.name = name;
        return this;
    }

    public Integer id() {
        return id;
    }

    public Eployee setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double salary() {
        return salary;
    }

    public Eployee setSalary(Double salary) {
        this.salary = salary;
        return this;
    }

    @Override
    public String toString() {
        return "Eployee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }
    public static class Builder{
        private String name;
        private Integer id;
        private Double salary;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder salary(Double salary) {
            this.salary = salary;
            return this;
        }
        public Eployee build(){
            return new Eployee(this);
        }

    }
}




















class Order{
    private String id;
    private String code;
    private Integer price;

    Order(){}
    private Order(Builder builder) {
        setCode(builder.code);
        setPrice(builder.price);
        setId(builder.id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", price=" + price +
                '}';
    }

    public static final class Builder{
        private String id;
        private String code;
        private Integer price;
        Builder(){}
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder price(Integer price) {
            this.price = price;
            return this;
        }

        public  Order build(){
            return new Order(this);
        }
    }
}
enum SubjectName{
    ENGLISH,MATH,SCIENCE;
}
class Subject{
    private float marks;
    private SubjectName subjectName;

    public Subject(Builder builder){
        setMarks(builder.marks);
        setSubjectName(builder.subjectName);
    }

    public float marks() {
        return marks;
    }

    public Subject setMarks(float marks) {
        this.marks = marks;
        return this;
    }

    public SubjectName subjectName() {
        return subjectName;
    }

    public Subject setSubjectName(SubjectName subjectName) {
        this.subjectName = subjectName;
        return this;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "marks=" + marks +
                ", subjectName=" + subjectName +
                '}';
    }

    public static class Builder{
        private float marks;
        private SubjectName subjectName;

        public float marks() {
            return marks;
        }

        public Builder setMarks(float marks) {
            this.marks = marks;
            return this;
        }

        public SubjectName subjectName() {
            return subjectName;
        }

        public Builder setSubjectName(SubjectName subjectName) {
            this.subjectName = subjectName;
            return this;
        }
        public Subject build(){
            return new Subject(this);
        }
    }
}
class Student{
    private String name;
    private int rollNumber;
    private Subject subject;

    public Student(){}

    public Student(Builder builder){
        setName(builder.name);
        setSubject(builder.subject);
        setRollNumber(builder.rollNumber);
    }
    public String name() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public int rollNumber() {
        return rollNumber;
    }

    public Student setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
        return this;
    }

    public Subject subject() {
        return subject;
    }

    public Student setSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", subject=" + subject +
                '}';
    }

    public static  class Builder{
        private String name;
        private int rollNumber;
        private Subject subject;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setRollNumber(int rollNumber) {
            this.rollNumber = rollNumber;
            return this;
        }

        public Builder setSubject(Subject subject) {
            this.subject = subject;
            return this;
        }

        public String name() {
            return name;
        }

        public int rollNumber() {
            return rollNumber;
        }

        public Subject subject() {
            return subject;
        }

        public Student build(){
            return  new Student(this);
        }
    }
}
public class Builder {
    public static void main(String[] args) {
        Order order = new Order.Builder().code("mobile").price(423).id("233").build();
        System.out.println(order);
        System.out.println(order);
        Order order1 = new Order.Builder().code("mobile1").price(42323).id("233").build();
        Eployee eployee = new Eployee.Builder().id(1).name("Hariom").salary(1000.0).build();
        System.out.println(eployee);

        Student student = new Student.Builder()
                .setName("Hariom")
                .setRollNumber(21)
                .setSubject(new Subject.Builder().setSubjectName(SubjectName.MATH).setMarks(10).build())
                .build();

        System.out.println(student);



    }
}
