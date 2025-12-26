class Solution {
    public int checkwaviness(int n)
    {   int count=0;
        String s = Integer.toString(n);
        for(int i=1 ;i<s.length()-1;i++)
        {
           char ch=s.charAt(i);
           if((s.charAt(i)<s.charAt(i-1) && s.charAt(i)<s.charAt(i+1)) ||( s.charAt(i)>s.charAt(i-1) && s.charAt(i)>s.charAt(i+1)) )count++;
        }
        return count;
    }
    public int totalWaviness(int num1, int num2) {
        int ans=0;
        for(int i= num1 ; i<=num2; i++)
        {
            ans=ans+checkwaviness(i);
        }
        return ans;
    }
}