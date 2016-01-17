public class Solution {
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(0, k, n);
        return result;
    }
    
    private void dfs(int prev, int k, int n) {
        if (k == 0) {
            if (n == 0)
                result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i=prev+1; i<=9; i++) {
            path.add(i);
            dfs(i, k - 1, n - i);
            path.remove(path.size() - 1);
        }
    }
}
