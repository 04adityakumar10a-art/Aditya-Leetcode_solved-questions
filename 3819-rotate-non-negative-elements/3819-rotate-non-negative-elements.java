class Solution {

    private void reverse(ArrayList<Integer> list, int l, int r) {
    while (l < r) {
        int temp = list.get(l);
        list.set(l, list.get(r));
        list.set(r, temp);
        l++;
        r--;
    }
}

    public int[] rotateElements(int[] nums, int k) {

        // collect indices of non-negative elements
        ArrayList<Integer> idx = new ArrayList<>();
        ArrayList<Integer> vals = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                idx.add(i);
                vals.add(nums[i]);
            }
        }

        int n = vals.size();
        if (n == 0) return nums;

        k %= n;
        if (k == 0) return nums;

       // LEFT rotation using reverse
          reverse(vals, 0, k - 1);
          reverse(vals, k, n - 1);
          reverse(vals, 0, n - 1);

        // put values back
        for (int i = 0; i < n; i++) {
            nums[idx.get(i)] = vals.get(i);
        }

        return nums;
    }
}