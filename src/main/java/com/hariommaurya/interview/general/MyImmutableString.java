package com.hariommaurya.interview.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class MyImmutableString<T> {
    private final String value;
    private final ArrayList<T> list;
    private final HashMap<T,T> map;
    public MyImmutableString(String value, ArrayList<T> list, HashMap<T, T> map) {
        System.out.println("Performing Deep copy of it!!");
        this.value = value;
        this.list = new ArrayList<>(list);
        this.map = new HashMap<>(map);
    }

    public String getValue() {
        return value;
    }

    public ArrayList<T> getList() {
        return new ArrayList<>(list);
    }

    public HashMap<T, T> getMap() {
        return new HashMap<>(map);
    }

    @Override
    public String toString() {
        return "MyString{" +
                "value='" + value + '\'' +
                ", list=" + list +
                ", map=" + map +
                '}';
    }

    public static void main(String[] args) {
        HashMap<Integer,String> map1 = new HashMap<>();
        map1.put(1,"hariom");
        map1.put(2,"Kiran");
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(69);
        String name = "Hariom java";
        MyImmutableString myImmutableString = new MyImmutableString(name,list1,map1);
        System.out.println(myImmutableString.toString());
        name="modified";
        list1.add(96);
        map1.put(3,"Testing");
        System.out.println(myImmutableString.toString());
        HashMap<Integer,String> map2 = myImmutableString.getMap();
        map2.put(4,"modified");
        ArrayList<Integer> list2 = myImmutableString.getList();
        list2.add(2342);
        System.out.println(myImmutableString.toString());
        Runnable r1 = ()->{
            System.out.println("Inside Runnable!!");
        };
        new Thread(r1).start();

        Consumer<Integer> consumer = (Integer number) -> System.out.println("number : "+number);
        consumer.accept(10);

        Supplier<String> supplier = () -> "Supplier Called";
        supplier.get();

        Function<String,Integer> function = (String city) -> {
            if(city.equalsIgnoreCase("Ghaziabad")){
                return 201001;
            }else {
                return 110080;
            }
        };
        function.apply("Ghaziabad");

        Predicate<Integer> predicate = (Integer number) -> number == 10;
        predicate.test(10);

    }
}
