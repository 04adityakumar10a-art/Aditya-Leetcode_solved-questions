class Solution {
    public String minWindow(String s, String t) {
        
        
        int[] map = new int[128]; // ASCII mapping for faster access
        int charsToCover = t.length();
        
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        
        int left = 0, minLeft = 0, minLen = Integer.MAX_VALUE;
        
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            
            if (map[rightChar] > 0) {
                charsToCover--;
            }
            map[rightChar]--;
            
            while (charsToCover == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }
                
                char leftChar = s.charAt(left);
                map[leftChar]++;
                if (map[leftChar] > 0) {
                    charsToCover++;
                }
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}