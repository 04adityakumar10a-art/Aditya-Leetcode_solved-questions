class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[] left = new int[26];
        int[] right = new int[26];

        Arrays.fill(left, n);

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            left[idx] = Math.min(left[idx], i);
            right[idx] = i;
        }

        List<String> ans = new ArrayList<>();
        int prevRight = -1;

        for (int i = 0; i < n; i++) {

            if (i != left[s.charAt(i) - 'a'])
                continue;

            int end = getRightBoundary(s, i, left, right);

            if (end == -1)
                continue;

            if (i > prevRight) {
                ans.add(s.substring(i, end + 1));
            } else {
                ans.set(ans.size() - 1,
                        s.substring(i, end + 1));
            }

            prevRight = end;
        }

        return ans;
    }

    private int getRightBoundary(String s, int start,
                                 int[] left, int[] right) {

        int end = right[s.charAt(start) - 'a'];

        for (int i = start; i <= end; i++) {

            int ch = s.charAt(i) - 'a';

            if (left[ch] < start)
                return -1;

            end = Math.max(end, right[ch]);
        }

        return end;
    }
}