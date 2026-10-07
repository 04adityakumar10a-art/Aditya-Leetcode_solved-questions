class Solution {
    Set<String> ans = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int lrem = 0;
        int rrem = 0;

        // Find minimum removals needed
        for (char c : s.toCharArray()) {
            if (c == '(') {
                lrem++;
            } else if (c == ')') {
                if (lrem > 0) {
                    lrem--;
                } else {
                    rrem++;
                }
            }
        }

        dfs(s, 0, lrem, rrem, 0, new StringBuilder());

        return new ArrayList<>(ans);
    }

    private void dfs(String s, int idx, int lrem, int rrem,
                     int open, StringBuilder curr) {

        if (idx == s.length()) {
            if (lrem == 0 && rrem == 0 && open == 0) {
                ans.add(curr.toString());
            }
            return;
        }

        char ch = s.charAt(idx);
        int len = curr.length();

        if (ch == '(') {

            // Option 1: Remove it
            if (lrem > 0) {
                dfs(s, idx + 1, lrem - 1, rrem, open, curr);
            }

            // Option 2: Keep it
            curr.append(ch);
            dfs(s, idx + 1, lrem, rrem, open + 1, curr);
            curr.setLength(len);

        } else if (ch == ')') {

            // Option 1: Remove it
            if (rrem > 0) {
                dfs(s, idx + 1, lrem, rrem - 1, open, curr);
            }

            // Option 2: Keep it only if there's a matching '('
            if (open > 0) {
                curr.append(ch);
                dfs(s, idx + 1, lrem, rrem, open - 1, curr);
                curr.setLength(len);
            }

        } else {

            // Normal character
            curr.append(ch);
            dfs(s, idx + 1, lrem, rrem, open, curr);
            curr.setLength(len);
        }
    }
}