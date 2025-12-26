import java.util.Arrays; // For splitting the string efficiently

class Solution {
    public String reverseWords(String s) {
        // Trim leading/trailing spaces and split into words
        String[] words = s.trim().split("\\s+");
        
        // Use StringBuilder for efficient concatenation
        StringBuilder reversed = new StringBuilder();
        
        // Iterate from the end to reverse words
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" "); // Add space except after the last word
            }
        }
        
        return reversed.toString();
    }
}