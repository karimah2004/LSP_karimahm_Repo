package org.howard.edu.lsp.midterm.question4;

import java.util.List;

/**
 * A driver class to test the functionality of the WordProcessor class.

 */
public class WordProcessorDriver {
    
    /**
     * The main method that runs several test cases
     * @param args 
     */
    public static void main(String[] args) {
        // Test case 1: Sentence with single longest word
        WordProcessor wp1 = new WordProcessor("This is a test with amazing results amazing achievements");
        List<String> longestWords1 = wp1.findLongestWords();
        System.out.println("Test 1 - Longest words: " + longestWords1); 
        // Expected Output: [achievements]
        
        // Test case 2: Sentence with multiple occurrences of the same longest word and length
        WordProcessor wp2 = new WordProcessor("Java is a powerful  powerful tool");
        List<String> longestWords2 = wp2.findLongestWords();
        System.out.println("Test 2 - Longest words: " + longestWords2); 
        // Expected Output: [powerful, powerful]
        
        // Test case 5: Sentence with single character words
        WordProcessor wp5 = new WordProcessor("A B C D E");
        List<String> longestWords5 = wp5.findLongestWords();
        System.out.println("Test 5 - Longest words: " + longestWords5); 
        // Expected Output: [A, B, C, D, E]
        
        // Test case 6: Empty string input
        WordProcessor wp6 = new WordProcessor("");
        List<String> longestWords6 = wp6.findLongestWords();
        System.out.println("Test 6 - Longest words: " + longestWords6); 
        // Expected Output: []
    }
}