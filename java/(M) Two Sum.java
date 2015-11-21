/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

public class Solution {
    class Pair implements Comparable<Pair> {
        public final int index;
        public final int value;
    
        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    
        @Override
        public int compareTo(Pair other) {
            //multiplied to -1 as the author needs descending sort order
            return 1 * Integer.valueOf(this.value).compareTo(other.value);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Pair[] pairs = new Pair[nums.length];
        for (int i=0; i<nums.length; i++) {
            pairs[i] = new Pair(i, nums[i]);
        }
        Arrays.sort(pairs);
        
        int head = 0;
        int tail = pairs.length - 1;
        while(true) {
            int sum = pairs[head].value + pairs[tail].value;
            if (sum == target) {
                int a = pairs[head].index+1;
                int b = pairs[tail].index+1;
                if (a < b)
                    return new int[]{a, b};
                else
                    return new int[]{b, a};
            }
            else if (sum < target)
                head++;
            else if (sum > target)
                tail--;
        }
    }
}

