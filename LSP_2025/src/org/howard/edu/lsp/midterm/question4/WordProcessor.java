package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

/**
 * Given sentence to find the longest words.
 */
public class WordProcessor {
    private String sentence;

    /**
     * Constructor
     * 
     * @param sentence The sentence to be processed
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds all the longest words in the sentence.
     * 
     * @return A list of all the longest words in the order they appear
     */
    public List<String> findLongestWords() {
        List<String> longestWords = new ArrayList<>();
        
   
        if (sentence == null || sentence.trim().isEmpty()) {
            return longestWords;
        }
        
        String[] words = sentence.trim().split("\\s+");
        
     // Find the maximum length of any word
        int maxLength = 0;
        for (String word : words) {
            maxLength = Math.max(maxLength, word.length());
        }
        
        // Collect all words with the maximum length
        for (String word : words) {
            if (word.length() == maxLength) {
                longestWords.add(word);
            }
        }
        
        return longestWords;
    }
}