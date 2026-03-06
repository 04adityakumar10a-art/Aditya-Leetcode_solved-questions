class Solution {
    public int minOperations(String s) {char last0='0';
    char last1='1';                          int count1=0;         
      int n=s.length();                     int count0=0; 
     for(int i=0;i<n;i++)
         {
             if(last0!=s.charAt(i))
             {
                 count0++;
             }
             else count1++;
             if(last0=='0')
             last0='1';
             else last0='0';
             
             if(last1=='0')
             last1='1';
             else last1='0';
         }
        return Math.min(count0,count1);
    }
}