public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return nums[0];
            
        int[] table = new int[nums.length];
        table[0] = nums[0];
        table[1] = Math.max(nums[0], nums[1]);
        for (int i=2; i<nums.length; i++) {
            table[i] = Math.max(table[i-2] + nums[i], table[i-1]);
        }
        return table[nums.length-1];
    }
}
