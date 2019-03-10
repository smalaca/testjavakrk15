package com.smalaca.wordcounter;

public interface Translator {
    String translate(String word);

    boolean isEnglishWord(String word);
}
