class Solution {
    public int countBinarySubstrings(String s) {
        ArrayList<Integer> ls= new ArrayList<>();
        int count =1;
        for(int i=0; i<s.length();i++)
        { if(i==s.length()-1) ls.add(count);
         else  if(s.charAt(i)==s.charAt(i+1)) count++;
          else{
            ls.add(count);
            count=1;
          }
        }
        int ans=0;
        for(int i=0;i<ls.size()-1;i++)
        {
            ans=ans+Math.min(ls.get(i),ls.get(i+1));
        }
        return ans;
    }
}