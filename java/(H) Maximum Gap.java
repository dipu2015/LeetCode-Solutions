/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
*/

// Use Bucket sort

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;

        int min = nums[0];
        int max = nums[0];
        for (int n : nums) {
            if (n < min)
                min = n;
            if (n > max)
                max = n;
        }
        
        int bucketSize = (int) Math.ceil((double)(max - min) / (double)(nums.length - 1));
        if (bucketSize == 0)
            return 0;
            
        int bucketNum = ((max - min) / bucketSize) + 1;
        int[] buckMax = new int[bucketNum];
        int[] buckMin = new int[bucketNum];
        for (int i=0; i<bucketNum; i++) {
            buckMax[i] = Integer.MIN_VALUE;
            buckMin[i] = Integer.MAX_VALUE;
        }
        
        for (int i=0; i<nums.length; i++) {
            int idx = (nums[i] - min) / bucketSize;
            if (nums[i] > buckMax[idx])
                buckMax[idx] = nums[i];
            if (nums[i] < buckMin[idx])
                buckMin[idx] = nums[i];
        }
        
        int maxDist = 0;
        int startGap = -1;
        for (int i=0; i<bucketNum; i++) {
            if (buckMax[i] == Integer.MIN_VALUE)
                continue;
            if (startGap != -1) {
                int dist = buckMin[i] - startGap;
                if (dist > maxDist)
                    maxDist = dist;
            }
            startGap = buckMax[i];
        }
        
        return maxDist;
    }
}
