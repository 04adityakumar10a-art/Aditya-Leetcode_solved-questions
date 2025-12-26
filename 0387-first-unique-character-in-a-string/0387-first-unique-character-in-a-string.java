class Solution {
    public int firstUniqChar(String s) {
        int[] frequency = new int[26]; 

        for (char c : s.toCharArray()) {
            frequency[c - 'a']++; // Map 'a' to 0, 'b' to 1, ..., 'z' to 25
        }
        for (int i = 0; i < s.length(); i++) {
            if (frequency[s.charAt(i) - 'a'] == 1) {
                return i; // Return the index of the first unique character
            }
        }
        // If no unique character is found, return -1
        return -1;
    }
}