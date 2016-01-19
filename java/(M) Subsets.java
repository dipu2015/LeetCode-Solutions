/*
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

public class Solution {
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();
    
    public List<List<Integer>> subsets(int[] nums) {
        dfsHelper(nums);
        return result;
    }
    
    private void dfsHelper(int[] nums) {
        result.add(new ArrayList<Integer>(path));
        if (path.size() == nums.length)
            return;
        for (int i=0; i<nums.length; i++) {
            if (!path.isEmpty() && nums[i] <= path.get(path.size()-1))
                continue;
            path.add(nums[i]);
            dfsHelper(nums);
            path.remove(path.size()-1);
        }
    }
}
