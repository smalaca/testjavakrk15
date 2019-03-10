package com.smalaca.wordcounter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;

public class WordCounterTest {

    private WordCounter wordCounter;
    private Translator translator;

    @Before
    public void initWordCounter() {
        translator = mock(Translator.class);
        BDDMockito.given(translator.isEnglishWord(anyString())).willReturn(false);

        wordCounter = new WordCounter(translator);
    }

    @Test
    public void shouldReturnZeroIfNoAddedWords() {
        String anyString = "kot";

        int result = wordCounter.countWords(anyString);

        assertEquals(0, result);
    }

    @Test
    public void shouldReturnWordCountIfAddedWord() {
        String anyString = "kot";
        wordCounter.addWord(anyString);

        int result = wordCounter.countWords(anyString);

        assertEquals(1, result);
    }

    @Test
    public void shouldReturnZeroIfDifferentWords() {
        wordCounter.addWord("kot");

        int result = wordCounter.countWords("pies");

        assertEquals(0, result);
    }

    @Test
    public void shouldCountWords() {
        String anyWord = "kot";
        wordCounter.addWord(anyWord);
        wordCounter.addWord(anyWord);

        int result = wordCounter.countWords(anyWord);

        assertEquals(2, result);
    }

    @Test
    public void shouldCountWordsInDifferentLanguages() {
        BDDMockito.given(translator.translate("cat")).willReturn("kot");
        BDDMockito.given(translator.isEnglishWord("cat")).willReturn(true);
        wordCounter.addWord("kot");
        wordCounter.addWord("cat");

        int result = wordCounter.countWords("cat");

        assertEquals(2, result);
    }
}
