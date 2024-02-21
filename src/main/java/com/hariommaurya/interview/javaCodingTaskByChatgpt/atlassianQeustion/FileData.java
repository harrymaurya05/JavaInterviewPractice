package com.hariommaurya.interview.javaCodingTaskByChatgpt.atlassianQeustion;

public class FileData {
    private String fileName;
    private int fileSize;
    private String collection;

    public FileData(String fileName, int fileSize, String collection) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.collection = collection;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }
    // Constructors, getters, and setters
}

