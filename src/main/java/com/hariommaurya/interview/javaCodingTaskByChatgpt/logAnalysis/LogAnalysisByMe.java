package com.hariommaurya.interview.javaCodingTaskByChatgpt.logAnalysis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogAnalysisByMe {
    /*Write a Java program to analyze log entries provided as multiline strings. Each log entry has the following format:
    *   [2023-01-01 12:30:45] INFO Application started
        [2023-01-01 12:35:21] ERROR Unexpected exception occurred
        [2023-01-01 12:40:15] INFO User logged in
    *   Requirements:
        Parse multiline log entries and extract relevant information.
        Calculate and display the total number of log entries for each log level.
        Identify and display the log entry with the earliest timestamp.
        Determine the average length of log messages.

    *   OUTPUT
    *   Number of Log Entries per Level:
        INFO: 2
        ERROR: 1

        Earliest Log Entry:
        [2023-01-01 12:30:45] INFO Application started

        Average Length of Log Messages: 27.33
        * Tips:
        Use regular expressions to parse multiline log entries.
        Utilize a Map to store log-level-wise statistics.
        Implement timestamp comparison for finding the earliest log entry.
        Calculate the average length by summing up the lengths and dividing by the number of log entries.
    * */
    private static double lengthOfMsg = 0L;
    private static double numberOfLogLines = 0;
    private static  TreeMap<Date,String> dateStringMap;
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static void main(String[] args) {
        String logs = "[2023-01-01 12:30:45] INFO Application started\n" +
                "[2023-01-01 12:35:21] ERROR Unexpected exception occurred\n" +
                "[2023-01-01 12:40:15] INFO User logged in\n";

        Map<String,Integer> logLevelCount = logsAnalyizer(logs);
        System.out.println("Number of Log Entries per Level:");
        logLevelCount.forEach((logLevel, count) -> {
            System.out.println(logLevel +":"+count);
        });
        System.out.println("\nEarliest Log Entry:");
        System.out.println(dateStringMap.get(dateStringMap.firstKey()));

        System.out.println("Average Length of Log Messages: " + lengthOfMsg/numberOfLogLines);
    }
    public static Map<String,Integer> logsAnalyizer(String logs){
        Map<String,Integer> logLevelCount = new LinkedHashMap<>();
        dateStringMap = new TreeMap<>();
        try(Scanner scanner = new Scanner(logs)){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                numberOfLogLines++;
                String logsList[] = line.split(" ");
                String logLevel = logsList[2];
                lengthOfMsg = lengthOfMsg + Arrays.stream(logsList,3,logsList.length).mapToInt(String::length).sum();
                String dateString = line.substring(1,line.indexOf("]"));
                SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
                try {
                    Date date = dateFormat.parse(dateString);
                    dateStringMap.put(date,line);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                logLevelCount.merge(logLevel, 1, Integer::sum);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return logLevelCount;
    }
}
