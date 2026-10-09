class Solution {
    public int minInsertions(String s) {
        int count = 0;
        int ans = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                count += 2;

                if (count % 2 != 0) {
                    ans++;
                    count--;
                }
            } else {
                count--;

                if (count < 0) {
                    ans++;
                    count = 1;
                }
            }
        }

        return ans + count;
    }
}