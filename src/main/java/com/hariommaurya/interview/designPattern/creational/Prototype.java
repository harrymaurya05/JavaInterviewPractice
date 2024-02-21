package com.hariommaurya.interview.designPattern.creational;


import java.util.Objects;

/*
  Prototype Design Pattern
  -> Use in case of where there is requirement of creating a clone or create a copy of class
*/
class Employee{
    private String name;
    private Integer id;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee clone(){
        Employee employee = new Employee();
        employee.id = this.id;
        employee.salary = this.salary;
        employee.name = this.name;
        return employee;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }
}
public class Prototype {

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("HARIOM");
        employee.setSalary(1000);
        System.out.println(employee.hashCode());
        Employee employee1 = employee.clone();
        System.out.println(employee1.hashCode());

    }
}
