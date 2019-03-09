package com.smalaca.wordcounter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterTest {

    @Test
    public void shouldReturnZeroIfNoAddedWords() {
        String anyString = "kot";
        WordCounter wordCounter = new WordCounter();

        int result = wordCounter.countWords(anyString);

        assertEquals(0, result);
    }

    @Test
    public void shouldReturnWordCountIfAddedWord() {
        String anyString = "kot";
        WordCounter wordCounter = new WordCounter();
        wordCounter.addWord(anyString);

        int result = wordCounter.countWords(anyString);

        assertEquals(1, result);
    }

    @Test
    public void shouldReturnZeroIfDifferentWords() {
        WordCounter wordCounter = new WordCounter();
        wordCounter.addWord("kot");

        int result = wordCounter.countWords("pies");

        assertEquals(0, result);
    }
}
