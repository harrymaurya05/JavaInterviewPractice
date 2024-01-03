package com.hariommaurya.interview.javaCodingTaskByChatgpt.atlassianQeustion;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<FileData> fileDataList = Arrays.asList(
                new FileData("file1.txt", 100, null),
                new FileData("file2.txt", 200, "collection1"),
                new FileData("file3.txt", 200, "collection1"),
                new FileData("file4.txt", 300, "collection2"),
                new FileData("file5.txt", 100, null)
        );

        FileProcessorService fileProcessorService = new FileProcessorService(fileDataList);

        // Calculate total size
        int totalSize = fileProcessorService.calculateTotalSize();
        System.out.println("Total size of files processed: " + totalSize);

        // Calculate top K collections
        int k = 2;
        Map<String, Integer> topCollections = fileProcessorService.calculateTopKCollectionsMostEfficient(k);
        System.out.println("Top " + k + " collections:");
        for (Map.Entry<String, Integer> entry : topCollections.entrySet()) {
            System.out.println("- " + entry.getKey() + " : " + entry.getValue());
        }
    }
}
