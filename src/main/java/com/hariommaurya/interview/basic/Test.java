package com.hariommaurya.interview.basic;

import java.util.*;
import java.util.stream.Collectors;

class EagerSingleTon1{
    private static EagerSingleTon1 eagerSingleTon1 = new EagerSingleTon1();
    private EagerSingleTon1(){

    }
    public static EagerSingleTon1 getInstance(){
        return eagerSingleTon1;
    }
}

class BillPughSingleton{
    private BillPughSingleton(){

    }
    private static class  SingleTon{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    public static BillPughSingleton getInstance(){
        return SingleTon.INSTANCE;
    }
}
class LazySingelton{
    private static  LazySingelton instance ;
    private  LazySingelton(){

    }
    public static LazySingelton getInstance(){
        if(instance == null){
            instance = new LazySingelton();
        }
        return instance;
    }
}

class SyncSingleton{
    private static SyncSingleton instance;
    private SyncSingleton(){

    }
    public static synchronized SyncSingleton getInstance(){
        if(instance == null){
            instance = new SyncSingleton();
        }
        return  instance;
    }
}

class DoubleCheckingSingleton{
    private static  volatile DoubleCheckingSingleton instance ;
    private DoubleCheckingSingleton(){

    }
    public synchronized  static DoubleCheckingSingleton getInstance(){
        if(instance == null){
            synchronized (DoubleCheckingSingleton.class){
                if(instance == null){
                    instance = new DoubleCheckingSingleton();
                }
            }
        }
        return instance;
    }

}
enum EnumSingleton{
    INSTANCE;
    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}


public class Test {
    public static void main(String[] args) {
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        enumSingleton.setValue(5);
        System.out.println(enumSingleton.getValue());
        enumSingleton.setValue(10);
        System.out.println(enumSingleton.getValue());

    }
}
