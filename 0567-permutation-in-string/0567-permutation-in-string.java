class Solution {
    public boolean isSame(int f1[],int f2[])
{   for(int i=0;i<26;i++)
{      if(f1[i]!=f2[i]) return false;}
       return true;
}
                  
                                     
    public boolean checkInclusion(String s1, String s2) {
        int freq[]= new int[26];
        for(int i=0;i<s1.length();i++)
        { freq[s1.charAt(i)-'a']++;}
        
        int winsiz=s1.length();
        for(int i=0;i<s2.length();i++ )
        { int winidx=0,idx=i;
          int freq2[]=new int[26];
          while(winidx<winsiz && idx<s2.length())
          {  freq2[s2.charAt(idx)-'a']++;
           winidx++;idx++;
          }
          if(isSame(freq,freq2))
             return true;

        }
        return false;
                        
    }
}