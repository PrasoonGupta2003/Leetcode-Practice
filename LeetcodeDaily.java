import java.util.*;

public class AlternatingSubsequence {

    // Method to find the longest alternating subsequence from words based on group bits
    public static List<String> longestAlternatingSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();

        // Edge case: if the input is empty, return empty list
        if (words.length == 0) return result;

        // Add the first word to the result
        result.add(words[0]);
        int prevGroup = groups[0];  // Track the group of the last added word

        // Loop through the rest of the words
        for (int i = 1; i < words.length; i++) {
            // If the current word's group differs from the previous one, it's alternating
            if (groups[i] != prevGroup) {
                result.add(words[i]);        // Add the word to the result
                prevGroup = groups[i];       // Update the previous group to current
            }
        }

        // Return the longest alternating subsequence
        return result;
    }

    // Main method for testing the logic
    public static void main(String[] args) {
        // Sample input
        String[] words = {"a", "b", "c", "d"};
        int[] groups = {1, 0, 1, 1};

        // Get the longest alternating subsequence
        List<String> result = longestAlternatingSubsequence(words, groups);

        // Print the result
        System.out.println("Longest Alternating Subsequence: " + result);
        // Example Output: [a, b, c] or [a, b, d]
    }
}
