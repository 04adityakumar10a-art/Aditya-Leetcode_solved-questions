class Solution {
    long[][] a;
    public long countBalanced(long low, long high) {
        a = new long[200][20];
        for (int i=0; i<200; i++)
            for (int j=0; j<20; j++)
                a[i][j] = -1;
        return count(high) - count(low-1);
    }

    private long count(long z) {
        if (z == 0)
            return 1;
        long ans = 0;
        int t = 0;
        long x = z;
        long y = 1;
        while (x > 0) {
            t++;
            x /= 10;
            y *= 10;
        }
        y /= 10;
        t--;
        int p = 0;
        long r = y - 1;
        while (r <= z) {
            //System.out.println(p + " " + t);
            ans += calc(p, t);
            p++;
            while (t > 0 && r + y > z) {
                y /= 10;
                p = -p;
                t--;
            }
            r += y;
            //System.out.println(p + " " + r + " " + t + " " + ans);
        }
        return ans;
    }

    private long calc(int d, int x) {
        int d0 = d + 100;
        if (a[d0][x] != -1)
            return a[d0][x];
        if (x == 0) {
            a[d0][x] = d == 0 ? 1 : 0;
            return a[d0][x];
        }
        a[d0][x] = 0;
        for (int i=0; i<=9; i++)
            a[d0][x] += calc(i - d, x - 1);
        return a[d0][x];
    }
}