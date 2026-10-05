class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(0);
            } else {
                int v = st.pop();
                int score = Math.max(2 * v, 1);
                st.push(st.pop() + score);
            }
        }

        return st.pop();
    }
}