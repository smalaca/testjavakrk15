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

    @Test
    public void shouldCountWords() {
        String anyWord = "kot";
        WordCounter wordCounter = new WordCounter();
        wordCounter.addWord(anyWord);
        wordCounter.addWord(anyWord);

        int result = wordCounter.countWords(anyWord);

        assertEquals(2, result);
    }

    @Test
    public void shouldCountWordsInDifferentLanguages() {
        WordCounter wordCounter = new WordCounter();
        wordCounter.addWord("kot");
        wordCounter.addWord("cat");
        givenTranslation("kot", "cat");

        int result = wordCounter.countWords("cat");

        assertEquals(2, result);
    }

    private void givenTranslation(String plWord, String engWord) {

    }
}
