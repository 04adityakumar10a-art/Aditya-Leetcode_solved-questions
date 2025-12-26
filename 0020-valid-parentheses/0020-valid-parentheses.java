import java.util.Stack;
import java.util.HashMap;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();

        // Map closing brackets to opening ones
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (char ch : s.toCharArray()) {
            // If it's a closing bracket
            if (map.containsKey(ch)) {
                // Pop from stack if not empty, else use dummy '#'
                char top = st.isEmpty() ? '#' : st.pop();
                if (top != map.get(ch)) {
                    return false;
                }
            } else {
                // It's an opening bracket
                st.push(ch);
            }
        }

        // Valid if no unmatched opening brackets
        return st.isEmpty();
    }
}
