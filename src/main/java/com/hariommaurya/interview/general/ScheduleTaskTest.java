package com.hariommaurya.interview.general;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ScheduleTaskTest {
    public static void runTask() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 15);
        calendar.set(Calendar.MINUTE, 40);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);



        Timer time = new Timer(); // Instantiate Timer Object

        // Start running the task on Monday at 15:40:00, period is set to 8 hours
        // if you want to run the task immediately, set the 2nd parameter to 0
        time.schedule(new CustomTask(), 0 , TimeUnit.SECONDS.toSeconds(2));
    }

    public static void main(String[] args) {

        //runTask();

        /*Lamda expression*/
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("Custom Task is Complete!!!");
                } catch (Exception ex){
                    System.out.println("Error is running task"+ ex.getMessage());
                }
            }
        },0,2000);
    }
}
class CustomTask extends TimerTask{

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println("Custom Task is Complete!!!");
            // Your task process

        } catch (Exception ex) {
            System.out.println("error running thread " + ex.getMessage());
        }
    }
}

