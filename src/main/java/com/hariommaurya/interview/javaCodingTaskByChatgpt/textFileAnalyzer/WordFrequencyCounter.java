package com.hariommaurya.interview.javaCodingTaskByChatgpt.textFileAnalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WordFrequencyCounter {
    /*Task: Word Frequency Counter
    Write a Java program that reads a text file and counts the frequency of each word. The program should output a list of unique words along with their frequencies in descending order.

    Requirements:
    Use a Map to store the word frequencies.
    Implement a method to read a text file and tokenize it into words.
    Ignore case while counting words (treat "Word" and "word" as the same).
    Exclude common English stop words (e.g., "the", "and", "is").
    Display the top N words with their frequencies, where N is a parameter that can be configured.
    Example Input:
    This is a sample text file. The text file contains multiple lines of text. Each line has different words.

    OUTPUT :
    Word: text, Frequency: 2
    Word: file, Frequency: 2
    Word: lines, Frequency: 2
    Word: This, Frequency: 1
    Word: sample, Frequency: 1

    */
    private static final int N = 3;
    public static void main(String[] args) throws IOException {
        String path = "/Users/hariommaurya/Documents/Java/new/src/main/java/com/hariommaurya/javaCodingTaskByChatgpt/textFileAnalyzer/wordFile";
        Map<String,Integer> wordMap = fileParser(path);
        System.out.println(wordMap.toString());
        getTopNWord(wordMap);
    }
    private static Map<String,Integer> fileParser(String path) throws IOException {
       /* Map<String,Integer> wordCount = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = reader.readLine()) != null){
                String words[] = line.split("\\s+");
                for(String word : words){
                    String cleanWord = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
                    if(!cleanWord.isEmpty() && !isStopWrod(cleanWord)){
                        wordCount.merge(cleanWord,1,Integer::sum);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return wordCount;*/
        Map<String,Integer> wordCount = new ConcurrentHashMap<>();
        Files.lines(Paths.get(path))
                .parallel()
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .map(word -> word.toLowerCase().replaceAll("[^a-zA-Z]", ""))
                .filter(cleanedWord -> !cleanedWord.isEmpty() && !isStopWord(cleanedWord))
                .forEach(cleanedWord -> wordCount.merge(cleanedWord, 1, Integer::sum));
        return wordCount;
    }
    private static boolean isStopWord(String word){
        String[] stopWord = {"the","is","of","at","that","it","in","and"};
        return Arrays.asList(stopWord).contains(word);
    }
    private static void getTopNWord(Map<String,Integer> words){
        words.entrySet().stream()
                .parallel()
                .sorted((e1,e2) -> Integer.compare(e2.getValue(),e1.getValue()))
                .limit(N)
                .forEach(entry -> System.out.println(entry.getKey() +" : "+ entry.getValue()));
    }
}
