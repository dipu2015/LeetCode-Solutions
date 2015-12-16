/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int a = searchSide(nums, target, 0);
        if (a == -1)
            return new int[]{-1, -1};
        int b = searchSide(nums, target, 1);
        return new int[]{a, b};
    }
    
    private int searchSide(int[] nums, int target, int side) {
        // side == 0: search left
        // side == 1: search right
        int i=0; 
        int j = nums.length-1;
        while(i < j-1) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                if (side == 0)
                    j = mid;
                else
                    i = mid;
            }
            else if (nums[mid] > target)
                j = mid - 1;
            else
                i = mid + 1;
        }
        if (side == 0) {
            if (nums[i] == target)
                return i;
            else if (nums[j] == target)
                return j;
            else
                return -1;
        }
        else {
            if (nums[j] == target)
                return j;
            else if (nums[i] == target)
                return i;
            else
                return -1;
        }
    }
}
