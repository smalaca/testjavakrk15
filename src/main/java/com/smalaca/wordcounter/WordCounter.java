package com.smalaca.wordcounter;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    private final Map<String, Integer> words = new HashMap<>();

    public int countWords(String word){
        return words.getOrDefault(word, 0);
    }

    public void addWord(String word) {
        words.put(word, countWords(word) + 1);
    }
}
