/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/

public class Solution {

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target);
        return result;
    }
    
    void helper(int[] nums, int target) {
        int sum = 0;
        for (int n : path)
            sum += n;

        for (int i=0; i<nums.length; i++) {
            if (path.size() > 0 && nums[i] < path.get(path.size()-1))
                continue;

            int newSum = sum + nums[i];
            if (newSum < target) {
                path.add(nums[i]);
                helper(nums, target);
                path.remove(path.size()-1);
            }
            else if (newSum == target) {
                List<Integer> pathClone = new ArrayList<Integer>(path);
                pathClone.add(nums[i]);
                result.add(pathClone);
            }
        }
    }    
}
