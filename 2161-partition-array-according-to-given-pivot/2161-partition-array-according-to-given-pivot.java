class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> small = new ArrayList<>();
        ArrayList<Integer> pt = new ArrayList<>();
        ArrayList<Integer> large = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot)
                small.add(nums[i]);
          else  if (nums[i] == pivot)
                pt.add(nums[i]);
            else
                large.add(nums[i]);
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(small);
        result.addAll(pt);
        result.addAll(large);
          for (int i = 0; i < nums.length; i++) {
            nums[i]=result.get(i);
          }
        return nums;

    }
}
