/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

public class Solution {
    public int maxSubArray(int[] nums) {
        // local max and max, 线性增长并维护子集，子集和为负即终止增长
        // if (nums.length == 0)
        //     return 0;
        // if (nums.length == 1)
        //     return nums[0];

        // int max = Integer.MIN_VALUE;
        // int localMax = Integer.MIN_VALUE;
        // int sum = 0;
        
        // for (int i=0; i<nums.length; i++) {
        //     sum += nums[i];
        //     if (sum > localMax) {
        //         localMax = sum;
        //     }
        //     if (sum < 0 || i == nums.length-1) {
        //         if (localMax > max)
        //             max = localMax;
        //         localMax = Integer.MIN_VALUE;
        //         sum = 0;
        //     }
        // }
        // return max;
        
        // Simple DP solution
        if (nums.length == 0)
            return 0;
        int max = nums[0];
        int localMax = nums[0];
        for (int i=1; i<nums.length; i++) {
            localMax = Math.max(nums[i], localMax + nums[i]);
            max = Math.max(max, localMax);
        }
        return max;
    }
}
