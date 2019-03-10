package com.smalaca.wordcounter;

import java.util.HashSet;
import java.util.Set;

public class WordCounter {
    private final Set<String> words = new HashSet();

    public int countWords(String word){
        return words.contains(word) ? 1 : 0;
    }

    public void addWord(String word) {
        words.add(word);
    }
}
