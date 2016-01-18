/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/

public class Solution {
    HashSet<List<Integer>> set = new HashSet<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> candList = new ArrayList<Integer>();
        for (int n : candidates)
            candList.add(n);
        Collections.sort(candList);
        for (int i=0; i<candList.size(); i++)
            candidates[i] = candList.get(i);
            
        dfsHelper(candidates, target, -1);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (List<Integer> list : set)
            result.add(list);
        return result;
    }
    
    private void dfsHelper(int[] candidates, int target, int idx) {
        if (target == 0) {
            set.add(new ArrayList<Integer>(path));
            return;
        }
        if (target < 0 || idx == candidates.length)
            return;
        for (int i=idx+1; i<candidates.length; i++) {
            int v = candidates[i];
            path.add(v);
            dfsHelper(candidates, target-v, i);
            path.remove(path.size()-1);
        }
    }
}

