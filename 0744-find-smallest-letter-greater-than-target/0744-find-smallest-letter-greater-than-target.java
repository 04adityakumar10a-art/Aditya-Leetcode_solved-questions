class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int check[] = new int[26];
        int n = letters.length;
        for(int i =0 ; i<n;i++)
        {
            check[letters[i]-'a']++;
        }

        for(int i = target-'a'+1 ;i<26;i++)
        {
          if(check[i] >0)
             return (char)(i+97);
        }
        return letters[0];
    }
}