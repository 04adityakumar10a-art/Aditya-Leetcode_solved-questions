class Solution {
    public boolean checkOnesSegment(String s) {
        int segment = 0;
        char prev =s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
             char curr =s.charAt(i);
              if((prev=='1' && curr=='0')  || (prev=='0' && curr=='1') ) segment++;
              if(segment >1) return false;
              prev=curr;
            }
        
        return true;
    }
}