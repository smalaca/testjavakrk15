package com.smalaca.wordcounter;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    private final Map<String, Integer> words = new HashMap<>();
    private final Translator translator;

    public WordCounter(Translator translator) {
        this.translator = translator;
    }

    public int countWords(String word){
        String translated = translate(word);

        return words.getOrDefault(translated, 0);
    }

    public void addWord(String word) {
        String translated = translate(word);

        words.put(translated, countWords(translated) + 1);
    }

    private String translate(String word) {
        String translated = word;

        if (translator.isEnglishWord(word)) {
            translated = translator.translate(word);
        }

        return translated;
    }
}
