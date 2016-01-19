/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class Solution {

    HashSet<List<Integer>> set = new HashSet<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int n : nums)
            list.add(n);
        Collections.sort(list);
        for (int i=0; i<list.size(); i++)
            nums[i] = list.get(i);
        
        dfsHelper(nums, 0);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>(set);
        return result;
    }
    
    private void dfsHelper(int[] nums, int k) {
        set.add(new ArrayList<Integer>(path));
        for (int i=k; i<nums.length; i++) {
            path.add(nums[i]);
            dfsHelper(nums, i+1);
            path.remove(path.size()-1);
        }
    }
}
