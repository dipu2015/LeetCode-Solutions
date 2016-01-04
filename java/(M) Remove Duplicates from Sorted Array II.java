/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
            
        int[] temp = new int[nums.length];
        temp[0] = nums[0];
        int pre = nums[0];
        int times = 1;
        int idx = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == pre)
                times++;
            else {
                pre = nums[i];
                times = 1;
            }
            if (times <= 2)
                temp[idx++] = nums[i];
        }
        for (int i=1; i<nums.length; i++)
            nums[i] = temp[i];
        return idx;
    }
}
