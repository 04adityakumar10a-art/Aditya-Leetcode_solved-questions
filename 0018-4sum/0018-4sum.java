

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;

        Arrays.sort(nums); // Sorting is mandatory

        HashSet<List<Integer>> s = new HashSet<>();

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int start = j + 1;
                int end = nums.length - 1;

                while (start < end) {
                    long sum = (long) nums[i] + nums[j] + nums[start] + nums[end]; // avoid overflow

                    if (sum == target) {
                        List<Integer> n = new ArrayList<>();
                        n.add(nums[i]);
                        n.add(nums[j]);
                        n.add(nums[start]);
                        n.add(nums[end]);
                        s.add(n);
                        start++;
                        end--;
                    } else if (sum > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return new ArrayList<>(s);
    }
}
