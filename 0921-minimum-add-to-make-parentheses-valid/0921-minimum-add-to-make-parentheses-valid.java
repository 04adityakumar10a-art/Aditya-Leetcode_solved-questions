class Solution {
    public int minAddToMakeValid(String s) {
        int ans=0;
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray())
        {
            if(c==')')
            { if(!st.isEmpty()  && st.peek()=='(' )
               { ans-- ;
                st.pop();}
                else ans++;

            }
            else{st.push(c); ans++;}
        }
        return Math.abs(ans);
    }
}