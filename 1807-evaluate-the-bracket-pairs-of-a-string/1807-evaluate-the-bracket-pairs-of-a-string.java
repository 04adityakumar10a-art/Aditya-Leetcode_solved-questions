class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String , String> mp = new HashMap<>();
        for(List<String> s2 : knowledge)
        {
            mp.put(s2.get(0),s2.get(1));
        }
        String ans = "";
        for(int i =0 ;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                String s1 = "";
                i++;
                while(s.charAt(i)!=')')
                {
                    s1+=s.charAt(i);
                    i++;
                }
                if(mp.containsKey(s1))
                {
                    ans+=mp.get(s1);
                }
                else ans+='?';
            }
            else ans+=s.charAt(i);
        }

        return ans ; 
    }
}