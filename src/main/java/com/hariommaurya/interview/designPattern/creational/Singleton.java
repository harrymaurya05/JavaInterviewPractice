package com.hariommaurya.interview.designPattern.creational;

import java.io.Serializable;

class DatabaseDriver implements Serializable {

    private static volatile DatabaseDriver databaseDriver;
    private DatabaseDriver() throws IllegalAccessException {
        if(databaseDriver != null){
            throw new IllegalAccessException();
        }
    }

    public static DatabaseDriver getInstance() throws IllegalAccessException {
        if(databaseDriver == null){
            synchronized (DatabaseDriver.class){
                if(databaseDriver == null){
                    databaseDriver = new DatabaseDriver();
                }
            }
        }
        return databaseDriver;
    }


}
public class Singleton {
    public static void main(String[] args) throws IllegalAccessException {
        System.out.println(DatabaseDriver.getInstance());
        System.out.println(DatabaseDriver.getInstance());
    }
}
