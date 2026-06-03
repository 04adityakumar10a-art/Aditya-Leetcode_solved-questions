class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int landThenWater =
                calc(landStartTime, landDuration,
                     waterStartTime, waterDuration);

        int waterThenLand =
                calc(waterStartTime, waterDuration,
                     landStartTime, landDuration);

        return Math.min(landThenWater, waterThenLand);
    }

    private int calc(int[] start1, int[] dur1,
                     int[] start2, int[] dur2) {

        int earliestFinishFirstRide = Integer.MAX_VALUE;

        for (int i = 0; i < start1.length; i++) {
            earliestFinishFirstRide =
                Math.min(earliestFinishFirstRide,
                         start1[i] + dur1[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < start2.length; i++) {
            ans = Math.min(ans,
                           Math.max(earliestFinishFirstRide,
                                    start2[i])
                           + dur2[i]);
        }

        return ans;
    }
}