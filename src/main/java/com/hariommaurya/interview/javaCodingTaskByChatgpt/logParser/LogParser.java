package com.hariommaurya.interview.javaCodingTaskByChatgpt.logParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LogParser {
    public static void main(String[] args) {
        String logData = "167:START\n" +
                "272:START\n" +
                "347:START\n" +
                "490:START\n" +
                "167:LOG 1\n" +
                "16:START\n" +
                "272:LOG 1\n" +
                "347:LOG 1\n" +
                "16:LOG 1\n" +
                "490:LOG 1\n" +
                "347:LOG 2\n" +
                "167:LOG 2\n" +
                "347:LOG 3\n" +
                "16:LOG 2\n" +
                "272:LOG 2\n" +
                "167:LOG 3\n" +
                "490:LOG 2\n" +
                "16:LOG 3\n" +
                "347:LOG 4\n" +
                "490:LOG 3\n" +
                "272:LOG 3\n" +
                "490:LOG 4\n" +
                "167:LOG 4\n" +
                "167:LOG 5\n" +
                "347:LOG 5\n" +
                "16:LOG 4\n" +
                "272:LOG 4\n" +
                "167:LOG 6\n" +
                "490:LOG 5\n" +
                "272:LOG 5\n" +
                "347:END\n" +
                "16:LOG 5\n" +
                "272:LOG 6\n" +
                "490:END\n" +
                "16:LOG 6\n" +
                "167:END\n" +
                "16:LOG 7\n" +
                "272:LOG 7\n" +
                "272:END\n" +
                "16:END\n";
        List<LogEntry> entries = parseLogData(logData);
        //System.out.println(entries);
        logAnalyzer(entries);
    }
    private static void logAnalyzer(List<LogEntry> entries){
        Map<String,String> data = entries.stream()
                .collect(Collectors.toMap(LogEntry::getStateCode,logEntry -> logEntry.originalLogEntry,(existingValue, newValue) -> existingValue + "\n" + newValue));
        data.forEach((key, value) -> System.out.println(value));
    }

    private static List<LogEntry> parseLogData(String logData) {
        List<LogEntry> entries = new ArrayList<>();
        try(Scanner scanner = new Scanner(logData)){
            while (scanner.hasNextLine()){
                String log = scanner.nextLine();
                String logList[] = log.split(":");
                String stateCode = logList[0];
                String message = logList[1];
                entries.add(new LogEntry(stateCode,message,log));
            }
        }
        return entries;
    }
    private static class LogEntry{
        private String stateCode;
        private String message;
        private String originalLogEntry;

        public LogEntry(String stateCode, String message, String originalLogEntry) {
            this.stateCode = stateCode;
            this.message = message;
            this.originalLogEntry = originalLogEntry;
        }

        public String getStateCode() {
            return stateCode;
        }

        public void setStateCode(String stateCode) {
            this.stateCode = stateCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getOriginalLogEntry() {
            return originalLogEntry;
        }

        public void setOriginalLogEntry(String originalLogEntry) {
            this.originalLogEntry = originalLogEntry;
        }

        @Override
        public String toString() {
            return "LogEntry{" +
                    "stateCode='" + stateCode + '\'' +
                    ", message='" + message + '\'' +
                    ", originalLogEntry='" + originalLogEntry + '\'' +
                    '}';
        }
    }
}
