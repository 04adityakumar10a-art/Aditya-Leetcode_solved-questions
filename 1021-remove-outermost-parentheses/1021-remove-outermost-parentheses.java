class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        int ans=0;
        int last = 0 ;
        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i <s.length();i++)
        {   char c= s.charAt(i);
            if(c==')')
            {
                if(!st.isEmpty() && st.peek()=='(')
                {
                    ans--;
                    st.pop();
                }
                else {st.push(c); ans++;}
            }
            else {st.push(c); ans++;}

            if(ans==0)
            {
              sb.append(s.substring(last+1, i));
              last=i+1;
            }
        }

        return sb.toString();
    }
}