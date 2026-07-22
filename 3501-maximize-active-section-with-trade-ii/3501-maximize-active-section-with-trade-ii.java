import java.util.*;


class Group {
    int start;
    int length;

    Group(int start, int length) {
        this.start = start;
        this.length = length;
    }
}

class SparseTable {
    private int[][] st;

    SparseTable(int[] nums) {
        int n = nums.length;
        st = new int[Integer.SIZE - Integer.numberOfLeadingZeros(Math.max(1, n)) + 1][n + 1];

        System.arraycopy(nums, 0, st[0], 0, n);

        for (int k = 1; k < st.length; k++) {
            for (int i = 0; i + (1 << k) <= n; i++) {
                st[k][i] = Math.max(st[k - 1][i],
                        st[k - 1][i + (1 << (k - 1))]);
            }
        }
    }

    int query(int l, int r) {
        if (l > r) return 0;
        int k = 31 - Integer.numberOfLeadingZeros(r - l + 1);
        return Math.max(st[k][l], st[k][r - (1 << k) + 1]);
    }
}

class Solution {

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {

        int ones = 0;
        for (char c : s.toCharArray())
            if (c == '1')
                ones++;

        Pair<List<Group>, int[]> info = getZeroGroups(s);

        List<Group> zeroGroups = info.getKey();
        int[] zeroIndex = info.getValue();

        if (zeroGroups.isEmpty()) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < queries.length; i++)
                ans.add(ones);
            return ans;
        }

        SparseTable st = new SparseTable(getMergeLengths(zeroGroups));

        List<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {

            int l = q[0];
            int r = q[1];

            int left = zeroIndex[l] == -1 ? -1 :
                    zeroGroups.get(zeroIndex[l]).length -
                            (l - zeroGroups.get(zeroIndex[l]).start);

            int right = zeroIndex[r] == -1 ? -1 :
                    r - zeroGroups.get(zeroIndex[r]).start + 1;

            int start = zeroIndex[l] + 1;
            int end = (s.charAt(r) == '1') ? zeroIndex[r] : zeroIndex[r] - 1;

            int res = ones;

            if (s.charAt(l) == '0' &&
                    s.charAt(r) == '0' &&
                    zeroIndex[l] + 1 == zeroIndex[r]) {

                res = Math.max(res, ones + left + right);

            } else if (start <= end - 1) {

                res = Math.max(res,
                        ones + st.query(start, end - 1));
            }

            if (s.charAt(l) == '0' &&
                    zeroIndex[l] + 1 <= end) {

                res = Math.max(res,
                        ones + left +
                                zeroGroups.get(zeroIndex[l] + 1).length);
            }

            if (s.charAt(r) == '0' &&
                    zeroIndex[l] < zeroIndex[r] - 1) {

                res = Math.max(res,
                        ones + right +
                                zeroGroups.get(zeroIndex[r] - 1).length);
            }

            ans.add(res);
        }

        return ans;
    }

    private Pair<List<Group>, int[]> getZeroGroups(String s) {

        List<Group> groups = new ArrayList<>();
        int[] idx = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '0') {

                if (i > 0 && s.charAt(i - 1) == '0')
                    groups.get(groups.size() - 1).length++;
                else
                    groups.add(new Group(i, 1));
            }

            idx[i] = groups.size() - 1;
        }

        return new Pair<>(groups, idx);
    }

    private int[] getMergeLengths(List<Group> groups) {

        int[] arr = new int[Math.max(0, groups.size() - 1)];

        for (int i = 0; i < groups.size() - 1; i++)
            arr[i] = groups.get(i).length + groups.get(i + 1).length;

        return arr;
    }
}