package com.hariommaurya.interview.javaCodingTaskByChatgpt.atlassianQeustion;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class FileProcessorService {
    private List<FileData> fileDataList;

    public FileProcessorService(List<FileData> fileDataList) {
        this.fileDataList = fileDataList;
    }

    public int calculateTotalSize() {
        return fileDataList.stream().mapToInt(FileData::getFileSize).sum();
    }


    public Map<String, Integer> calculateTopKCollections(int k) {
        return fileDataList.stream()
                .filter(fileData -> fileData.getCollection() != null)
                .collect(Collectors.groupingBy(FileData::getCollection, Collectors.summingInt(FileData::getFileSize)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(k)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    // More efficient calculateTopKCollections method
    public Map<String, Integer> calculateTopKCollectionsEfficient(int k) {
        return fileDataList.stream()
                .filter(fileData -> fileData.getCollection() != null)
                .collect(Collectors.groupingBy(FileData::getCollection, Collectors.summingInt(FileData::getFileSize)))
                .entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue()))
                .limit(k)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    // Even more efficient calculateTopKCollections method using a priority queue
    public Map<String, Integer> calculateTopKCollectionsMostEfficient(int k) {
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue));
        fileDataList.stream()
                .filter(fileData -> fileData.getCollection() != null)
                .collect(Collectors.groupingBy(FileData::getCollection, Collectors.summingInt(FileData::getFileSize)))
                .forEach((collection, size) -> {
                    Map.Entry<String, Integer> entryToAdd = new AbstractMap.SimpleEntry<>(collection, size);
                    minHeap.add(entryToAdd);
                    if (minHeap.size() > k) {
                        minHeap.poll();
                    }
                });

        return new ArrayList<>(minHeap)
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}
