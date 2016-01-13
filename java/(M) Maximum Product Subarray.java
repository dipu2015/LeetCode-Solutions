public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;
            
        int localMax = nums[0];
        int localMin = nums[0];
        int max = nums[0];
        for (int i=1; i<nums.length; i++) {
            int lm = localMax;
            localMax = getMax(new int[]{nums[i], nums[i] * localMax, nums[i] * localMin});
            localMin = getMin(new int[]{nums[i], nums[i] * localMin, nums[i] * lm});
            max = Math.max(max, localMax);
        }
        return max;
    }
    
    private int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int n : nums)
            max = Math.max(max, n);
        return max;
    }
    private int getMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int n : nums)
            min = Math.min(min, n);
        return min;
    }
}
