/* 
Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
*/

// Should also try to solve it with iterations
public class Solution {
    
    public int search(int[] nums, int target) {
        return searchSubArray(nums, 0, nums.length-1, target);
    }
    
    int searchSubArray(int[] nums, int start, int end, int target) {
        if (start == end) {
            if (nums[start] == target)
                return start;
            else
                return -1;
        }

        int mid = (start + end) / 2;
        if (nums[mid] == target)
            return mid;
        else if (nums[start] <= nums[mid]) {
            if (nums[start] <= target && target <= nums[mid])
                return searchSubArray(nums, start, mid, target);
            else
                return searchSubArray(nums, mid+1, end, target);
        }
        else {
            if (nums[mid+1] <= target && target <= nums[end])
                return searchSubArray(nums, mid+1, end, target);
            else
                return searchSubArray(nums, start, mid, target);
        }
    }
}
