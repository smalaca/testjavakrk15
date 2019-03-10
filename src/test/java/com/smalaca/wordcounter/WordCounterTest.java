package com.smalaca.wordcounter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;

public class WordCounterTest {

    private static final String ANY_STRING = "kot";
    private static final String DIFFFERENT_WORD = "pies";
    private static final String ANY_STRING_TRANSLATED = "cat";
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
        int result = wordCounter.countWords(ANY_STRING);

        assertEquals(0, result);
    }

    @Test
    public void shouldReturnWordCountIfAddedWord() {
        wordCounter.addWord(ANY_STRING);

        int result = wordCounter.countWords(ANY_STRING);

        assertEquals(1, result);
    }

    @Test
    public void shouldReturnZeroIfDifferentWords() {
        wordCounter.addWord(ANY_STRING);

        int result = wordCounter.countWords(DIFFFERENT_WORD);

        assertEquals(0, result);
    }

    @Test
    public void shouldCountWords() {
        wordCounter.addWord(ANY_STRING);
        wordCounter.addWord(ANY_STRING);

        int result = wordCounter.countWords(ANY_STRING);

        assertEquals(2, result);
    }

    @Test
    public void shouldCountWordsInDifferentLanguages() {
        givenWordToTranslation();
        wordCounter.addWord(ANY_STRING);
        wordCounter.addWord(ANY_STRING_TRANSLATED);

        int result = wordCounter.countWords(ANY_STRING_TRANSLATED);

        assertEquals(2, result);
    }

    private void givenWordToTranslation() {
        BDDMockito.given(translator.translate(ANY_STRING_TRANSLATED)).willReturn(ANY_STRING);
        BDDMockito.given(translator.isEnglishWord(ANY_STRING_TRANSLATED)).willReturn(true);
    }
}
