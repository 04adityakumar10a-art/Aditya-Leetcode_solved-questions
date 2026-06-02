class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int ans = Integer.MAX_VALUE;

        int n = landStartTime.length;
        int m = waterStartTime.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // Land -> Water
                int landFinish = landStartTime[i] + landDuration[i];
                int waterFinish = Math.max(landFinish, waterStartTime[j])
                                  + waterDuration[j];

                ans = Math.min(ans, waterFinish);

                // Water -> Land
                int waterFirstFinish = waterStartTime[j] + waterDuration[j];
                int landSecondFinish = Math.max(waterFirstFinish, landStartTime[i])
                                       + landDuration[i];

                ans = Math.min(ans, landSecondFinish);
            }
        }

        return ans;
    }
}