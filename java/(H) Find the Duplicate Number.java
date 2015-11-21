public class Solution {
    public int findDuplicate(int[] nums) {
        // Binary Search + Pigeonhole Principle
        int min = 1, max = nums.length - 1;
        while(min <= max) {
            int mid = (max + min) / 2;
            int cnt = 0;
            for (int i=0; i<nums.length; i++) {
                if (nums[i] <= mid)
                    cnt ++;
            }
            if (cnt > mid)
                max = mid - 1;
            else
                min = mid + 1;
        }
        return min;
    }
}
