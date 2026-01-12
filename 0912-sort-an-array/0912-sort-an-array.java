class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for(int num : nums)
        {
            minheap.add(num);
        }
        int i=0;
        while(!minheap.isEmpty())
        {
            nums[i++]=minheap.poll();
        }
        return nums;
    }
}