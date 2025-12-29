
class Solution {

    char[] digits;
    Long[][][][][][] memo;

    public long countBalanced(long low, long high) {
        return countUpTo(high) - countUpTo(low - 1);
    }

    private long countUpTo(long x) {
        if (x <= 0) return 0;
        digits = String.valueOf(x).toCharArray();
        int n = digits.length;

        memo = new Long[n][401][2][2][2][18];
        return dfs(0, 200, 0, 1, 0, 0);
    }

    private long dfs(
        int pos,
        int diff,
        int parity,
        int tight,
        int started,
        int length
    ) {
        if (pos == digits.length) {
            return (started == 1 && length >= 2 && diff == 200) ? 1 : 0;
        }

        if (memo[pos][diff][parity][tight][started][length] != null) {
            return memo[pos][diff][parity][tight][started][length];
        }

        int limit = tight == 1 ? digits[pos] - '0' : 9;
        long ways = 0;

        for (int d = 0; d <= limit; d++) {
            int ntight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {
                ways += dfs(pos + 1, diff, parity, ntight, 0, 0);
            } else {
                int newDiff = diff + ((parity == 0) ? d : -d);
                if (newDiff >= 0 && newDiff <= 400) {
                    ways += dfs(
                        pos + 1,
                        newDiff,
                        parity ^ 1,
                        ntight,
                        1,
                        length + 1
                    );
                }
            }
        }

        return memo[pos][diff][parity][tight][started][length] = ways;
    }
}
