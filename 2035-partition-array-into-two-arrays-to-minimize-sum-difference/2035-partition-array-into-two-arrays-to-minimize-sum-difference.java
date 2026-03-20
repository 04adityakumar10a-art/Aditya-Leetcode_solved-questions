class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = 0;

        for (int num : nums) totalSum += num;

        int[] leftArr = Arrays.copyOfRange(nums, 0, n);
        int[] rightArr = Arrays.copyOfRange(nums, n, nums.length);

        List<List<Integer>> left = new ArrayList<>();
        List<List<Integer>> right = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            left.add(new ArrayList<>());
            right.add(new ArrayList<>());
        }

        generate(leftArr, 0, 0, 0, left);
        generate(rightArr, 0, 0, 0, right);

        // sort right side for binary search
        for (int i = 0; i <= n; i++) {
            Collections.sort(right.get(i));
        }

        int ans = Integer.MAX_VALUE;

        // try all combinations
        for (int k = 0; k <= n; k++) {
            List<Integer> leftList = left.get(k);
            List<Integer> rightList = right.get(n - k);

            for (int leftSum : leftList) {
                int target = (totalSum / 2) - leftSum;

                int idx = Collections.binarySearch(rightList, target);

                if (idx < 0) idx = -idx - 1;

                // check closest elements
                if (idx < rightList.size()) {
                    int sum = leftSum + rightList.get(idx);
                    ans = Math.min(ans, Math.abs(totalSum - 2 * sum));
                }

                if (idx > 0) {
                    int sum = leftSum + rightList.get(idx - 1);
                    ans = Math.min(ans, Math.abs(totalSum - 2 * sum));
                }
            }
        }

        return ans;
    }

    void generate(int[] arr, int idx, int count, int sum, List<List<Integer>> res) {
        if (idx == arr.length) {
            res.get(count).add(sum);
            return;
        }

        // pick
        generate(arr, idx + 1, count + 1, sum + arr[idx], res);

        // not pick
        generate(arr, idx + 1, count, sum, res);
    }
}