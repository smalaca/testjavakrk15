package com.smalaca.wordcounter;

public class WordCounter {
    private int count = 0;

    public int countWords(String word){
        return count;
    }

    public void addWord(String word) {
        count++;
    }
}
