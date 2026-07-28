class Solution {
    public String smallestPalindrome(String s) {
        if (s.length() == 1) return s;

        int[] arr = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        StringBuilder firstHalf = new StringBuilder();
        String middle = "";

        // Build the smallest lexicographical first half
        for (int i = 0; i < 26; i++) {
            int count = arr[i] / 2;

            while (count-- > 0) {
                firstHalf.append((char) ('a' + i));
            }

            arr[i] %= 2; // keep only leftover count
        }

        // Find middle character (if any)
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 1) {
                middle = String.valueOf((char) ('a' + i));
                break;
            }
        }

        String secondHalf = new StringBuilder(firstHalf).reverse().toString();

        return firstHalf.toString() + middle + secondHalf;
    }
}