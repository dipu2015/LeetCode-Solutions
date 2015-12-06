/*
You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].
*/

public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int n : nums)
            list.add(n);
        Collections.sort(list);

        List<Integer> result = new ArrayList<Integer>();
        for (int i=0; i<nums.length; i++) {
            int index = findIndex(list, 0, list.size()-1, nums[i]);
            while(index >= 1 && list.get(index-1).equals(list.get(index)))
                index--;
                
            result.add(index);
            list.remove(index);
        }
        return result;
    }
    
    private int findIndex(List<Integer> nums, int start, int end, int target) {
        int mid = (start + end) / 2;
        if (nums.get(mid) == target)
            return mid;
        else if (nums.get(mid) > target)
            return findIndex(nums, start, mid-1, target);
        else
            return findIndex(nums, mid+1, end, target);
    }
}
