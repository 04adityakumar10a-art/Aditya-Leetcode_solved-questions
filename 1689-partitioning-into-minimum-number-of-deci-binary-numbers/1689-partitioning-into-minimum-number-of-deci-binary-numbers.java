class Solution {
    public int minPartitions(String s) {
        if(s.length()==1) return s.charAt(0)-'0';
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            int val=s.charAt(i)-'0';
            ans=Math.max(ans,val);
        }
        return ans;
    }
}