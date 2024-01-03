package com.hariommaurya.interview.javaCodingTaskByChatgpt.logAnalysis;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class LogAnalysisByChatgpt {

    /*Write a Java program to analyze log entries provided as multiline strings. Each log entry has the following format:
    *   [2023-01-01 12:30:45] INFO Application started
        [2023-01-01 12:35:21] ERROR Unexpected exception occurred
        [2023-01-01 12:40:15] INFO User logged in

    *   Requirements:
        Parse multiline log entries and extract relevant information.
        Calculate and display the total number of log entries for each log level.
        Identify and display the log entry with the earliest timestamp.
        Determine the average length of log messages.

        * Additional Requirements:
        Implement a method to filter log entries based on a specified time range.
        Identify and display the log entry with the most repeated message.
        Implement a mechanism to anonymize sensitive information (e.g., user names, IP addresses) in log messages.

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

    public static void main(String[] args) {
        String logs = "[2023-01-01 12:30:45] INFO Application started\n" +
                "[2023-01-01 12:35:21] ERROR Unexpected exception occurred\n" +
                "[2023-01-01 12:40:15] INFO User 'john.doe' logged in from IP 192.168.1.10\n" +
                "[2023-01-01 12:42:00] INFO Database query executed by user 'john.doe'\n" +
                "[2023-01-01 12:45:10] ERROR Authentication failure for user 'admin' from IP 192.168.1.20\n" +
                "[2023-01-01 12:47:30] INFO User 'john.doe' logged out\n";

        List<LogEntry> logEntries = logParser(logs);
        logAnalyzer(logEntries);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        getLogsBetweenRange(logEntries,LocalDateTime.parse("2023-01-01 12:35:21",formatter),LocalDateTime.parse("2023-01-01 12:45:10",formatter));
        getMostRepeatedEntry(logEntries);
        anonymizeSensitiveInformation(logEntries);
        findCorrelationInLogs(logEntries);
        performSentimentalAnalysis(logEntries);
    }

    private static void logAnalyzer(List<LogEntry> logEntries){
        //System.out.println(logEntries);
        Map<String, Long> logLevelCount = logEntries.stream()
                .collect(Collectors.groupingBy(LogEntry::getLogLevel,Collectors.counting()));

        Optional<LogEntry> earliestLogEntry = logEntries.stream()
                .min(Comparator.comparing(LogEntry::getTimesStamp));

        double averageMessageLength = logEntries.stream()
                .mapToInt(entry -> entry.getMessage().length())
                .average()
                .orElse(0.0);

        // Print results
        System.out.println("Number of Log Entries per Level:");
        logLevelCount.forEach((logLevel,count) -> System.out.println(logLevel+":"+count));

        System.out.println("\nEarliest Log Entry:");
        earliestLogEntry.ifPresent(logEntry -> System.out.println(logEntry.originalEntry));

        System.out.println("\nAverage Length of Log Messages: " + averageMessageLength);
    }
    private  static void findCorrelationInLogs(List<LogEntry> entries){
        Map<String,ArrayList<LogEntry>> correlatedLogs = new HashMap<>();
        for(int i=0; i<entries.size()-1; i++){
            LogEntry currentEntry = entries.get(i);
            LogEntry nextEntry = entries.get(i+1);
            if(currentEntry.getMessage().contains("logged") ||
            nextEntry.getMessage().contains("Database query executed")){
                String correlationKey = currentEntry.getUserName();
                correlatedLogs.computeIfAbsent(correlationKey, k -> new ArrayList<>());
                correlatedLogs.get(correlationKey).add(currentEntry);
                correlatedLogs.get(correlationKey).add(nextEntry);
            }
        }
        System.out.println(correlatedLogs.toString());
        correlatedLogs.forEach((key,value) -> {
            System.out.println("Correlation Key: " + key);
            entries.forEach(entry -> System.out.println(entry.getOriginalEntry()));
        });
    }
    public static void performSentimentalAnalysis(List<LogEntry> entries){
        Map<String, String> sentimentAnalysis  = entries.stream()
                .collect(Collectors.toMap(LogEntry::getOriginalEntry,entry -> getSentiment(entry.getMessage())));
        System.out.println("Sentiment Analysis :");
        sentimentAnalysis.forEach((key,value)-> System.out.println(key +" : "+value));
    }
    private static String getSentiment(String log){
        return log.contains("ERROR") ? "Negative" : "Neutral";
    }

    private static List<LogEntry> logParser(String logs){
        List<LogEntry> logEntries = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try(Scanner scanner = new Scanner(logs)){
            while (scanner.hasNextLine()) {
                String log = scanner.nextLine();
                LocalDateTime timesStamp = LocalDateTime.parse(log.substring(1, log.indexOf("]")), formatter);
                String message = log.substring(log.indexOf("]") + 2);
                String logLevel = log.split(" ")[2];
                logEntries.add(new LogEntry(timesStamp, logLevel, message, log));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return logEntries;
    }

    private static void getLogsBetweenRange(List<LogEntry> logEntries,LocalDateTime startTime, LocalDateTime endTime){
        List<LogEntry> entries = logEntries.stream()
                .filter(entry -> entry.getTimesStamp().isAfter(startTime) & entry.getTimesStamp().isBefore(endTime))
                .collect(Collectors.toList());
        System.out.println("\nLog Entries in Time Range:");
        entries.forEach(logEntry -> System.out.println(logEntry.originalEntry));
    }

    private static void getMostRepeatedEntry(List<LogEntry> entries){
        Map<String,Long> countOfMostRepeatedMessage = entries.stream()
                .collect(Collectors.groupingBy(LogEntry::getMessage,Collectors.counting()));
        String mostRepeatedMessage = countOfMostRepeatedMessage.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No Message");
        System.out.println("\nLog Entry with Most Repeated Message:");
        System.out.println("Message: " + mostRepeatedMessage);
    }

    private static void anonymizeSensitiveInformation(List<LogEntry> entries){
        List<LogEntry> anonymizeEntries = entries.stream()
                .map(entry -> entry.anonymizeSensitiveInformation())
                .collect(Collectors.toList());
        System.out.println("\nAnonymized Log Messages:");
        anonymizeEntries.forEach(entry -> System.out.println(entry.message));
    }



    private static class LogEntry{
        private LocalDateTime timesStamp;
        private String logLevel;
        private String message;
        private String originalEntry;

        public LogEntry(LocalDateTime timesStamp, String logLevel, String message, String originalEntry) {
            this.timesStamp = timesStamp;
            this.logLevel = logLevel;
            this.message = message;
            this.originalEntry = originalEntry;
        }

        public LocalDateTime getTimesStamp() {
            return timesStamp;
        }

        public void setTimesStamp(LocalDateTime timesStamp) {
            this.timesStamp = timesStamp;
        }

        public String getLogLevel() {
            return logLevel;
        }

        public void setLogLevel(String logLevel) {
            this.logLevel = logLevel;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getOriginalEntry() {
            return originalEntry;
        }

        public void setOriginalEntry(String originalEntry) {
            this.originalEntry = originalEntry;
        }
        public LogEntry anonymizeSensitiveInformation(){
            String anonymizeMessage = message.replaceAll("User '[^']*'", "user '***'").replaceAll("user '[^']*'", "user '***'")
                    .replaceAll("IP \\d+\\.\\d+\\.\\d+\\.\\d+", "IP ***.***.***.***");
            return  new LogEntry(timesStamp,logLevel,anonymizeMessage,originalEntry);

        }
        public String getUserName(){
            return message.substring(message.indexOf("User"),message.indexOf("logged"))
                    .split(" ")[1].replaceAll("'","");
        }

        @Override
        public String toString() {
            return "LogEntry{" +
                    "timesStamp=" + timesStamp +
                    ", logLevel='" + logLevel + '\'' +
                    ", message='" + message + '\'' +
                    ", originalEntry='" + originalEntry + '\'' +
                    '}';
        }
    }

}
