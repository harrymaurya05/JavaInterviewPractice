package com.hariommaurya.interview.designPattern.creational;


import java.util.function.Predicate;

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
public class Builder {
    public static void main(String[] args) {
        Order order = new Order.Builder().code("mobile").price(423).id("233").build();
        System.out.println(order);
        System.out.println(order);

        Eployee eployee = new Eployee.Builder().id(1).name("Hariom").salary(1000.0).build();
        System.out.println(eployee);
    }
}
