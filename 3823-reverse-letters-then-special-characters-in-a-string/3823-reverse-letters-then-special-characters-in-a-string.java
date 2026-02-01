class Solution {
    public String reverseByType(String s) {
        Deque<Character> letters = new ArrayDeque<>();
        Deque<Character> others = new ArrayDeque<>();

        // Push characters by type
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c))
                letters.push(c);
            else
                others.push(c);
        }

        StringBuilder ans = new StringBuilder();

        // Rebuild string
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c))
                ans.append(letters.pop());
            else
                ans.append(others.pop());
        }

        return ans.toString();
    }
}
