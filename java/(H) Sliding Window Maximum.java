public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)
            return new int[0];
            
        int[] rst = new int[nums.length - k + 1];
        PriorityQueue<Integer> window = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0; i<k; i++)
            window.add(nums[i]);
        rst[0] = window.peek();
        for (int i=k; i<nums.length; i++) {
            window.remove(nums[i-k]);
            window.add(nums[i]);
            rst[i-k+1] = window.peek();
        }
        return rst;
    }
}
