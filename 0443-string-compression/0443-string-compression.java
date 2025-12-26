class Solution {
    public int compress(char[] chars) {
        int i = 0; // Read pointer
        int y = 0; // Write pointer
        
        while (i < chars.length) {
            char current = chars[i];
            int count = 0;
            
            // Count consecutive characters
            while (i < chars.length && chars[i] == current) {
                i++;
                count++;
            }
            
            // Write the character
            chars[y++] = current;
            
            // Write the count (if >1)
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[y++] = c;
                }
            }
        }
        
        return y; // New length
    }
}