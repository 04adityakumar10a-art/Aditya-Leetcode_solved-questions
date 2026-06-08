class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> small = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> large = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot)
                small.add(num);
            else if (num == pivot)
                equal.add(num);
            else
                large.add(num);
        }

        int idx = 0;

        for (int num : small)
            nums[idx++] = num;

        for (int num : equal)
            nums[idx++] = num;

        for (int num : large)
            nums[idx++] = num;

        return nums;
    }
}