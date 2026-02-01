class Solution {
    public String reverseByType(String s) {
      Stack<Character> ch = new Stack<>();
      Stack<Character> spl = new Stack<>();
      String ans ="";
      for(int i=0;i<s.length();i++)
      {
        if(s.charAt(i)>='a' && s.charAt(i)<='z') ch.push(s.charAt(i));
        else spl.push(s.charAt(i));
      }  
      for(int i=0;i<s.length();i++)
      {
        if(s.charAt(i)>='a' && s.charAt(i)<='z')
        { ans=ans+ch.pop();}
        else ans=ans+spl.pop();
      }
      return ans;  
    }
}