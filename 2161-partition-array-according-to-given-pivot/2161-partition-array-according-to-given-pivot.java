class Solution {
    public int[] pivotArray(int[] nums, int target) {

        int[] arr = new int[nums.length];

        int arrCount = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < target){
                arr[arrCount++] = nums[i];
            }
        } 

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                arr[arrCount++] = nums[i];
            }
        } 

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > target){
                arr[arrCount++] = nums[i];
            }
        }

        return arr;
    }
}