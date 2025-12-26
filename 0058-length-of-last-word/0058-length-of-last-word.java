class Solution {
    public int lengthOfLastWord(String s) {
        int i =0,j;
        
        s=s.trim();
        if(s.length()<=1) return s.length();
        for(j=0;j<s.length();j++)
        {
            if(s.charAt(j)==' ') i=j;
        }
        if(i==0)return s.length();
       else return s.substring(i+1).length();
    }
}