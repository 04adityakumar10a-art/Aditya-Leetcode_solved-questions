class Solution {
    public boolean isPalindrome(String s) {
        // Remove all non-alphanumeric characters and convert to lowercase
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        // Check if the cleaned string is a palindrome
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }
}