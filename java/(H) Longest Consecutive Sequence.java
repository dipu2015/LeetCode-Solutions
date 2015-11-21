public class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i=0; i<nums.length; i++)
            set.add(nums[i]);

        int max = 0;
        for (int i=0; i<nums.length; i++) {
            int len = 1;
            int v = nums[i] + 1;
            while(set.contains(v)) {
                len++;
                set.remove(v);
                v++;
            }
            v = nums[i] - 1;
            while(set.contains(v)) {
                len++;
                set.remove(v);
                v--;
            }
            if (len > max)
                max = len;
        }
        return max;
    }
}
