class Solution {
    public int numberOfSpecialChars(String str) {
      int count=0;
      HashMap<Character,Boolean> mp= new HashMap<>();
        for(int i=0;i<str.length();i++)
      {
        mp.put(str.charAt(i),false);
      }
      for(int i=0;i<str.length();i++)
      {
        if(str.charAt(i)>='a' && str.charAt(i)<='z')
        { char ch = Character.toUpperCase(str.charAt(i));
          if(mp.containsKey(ch) && mp.get(str.charAt(i))==false) 
          {
             count++;
             mp.put(str.charAt(i),true);
             mp.put(Character.toUpperCase(str.charAt(i)),true);
          }
        }
        else
           {char ch = Character.toLowerCase(str.charAt(i));
            if(mp.containsKey(ch) && mp.get(str.charAt(i))==false)
          {
             count++;
             mp.put(str.charAt(i),true);
             mp.put(Character.toLowerCase(str.charAt(i)),true);
          }
           }
        
      }
      return count;
    }
}