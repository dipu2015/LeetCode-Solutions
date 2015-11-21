public class Solution {
    
    List<Integer> path = new ArrayList<Integer>();
    int solutionNum = 0;

    public int totalNQueens(int n) {
        helper(n);
        return solutionNum;
    }
    
    void helper(int n) {
        for (int i=0; i<n; i++) {
            if (canPlace(i)) {
                path.add(i);
                if (path.size() == n) {
                    solutionNum++;
                }
                else
                    helper(n);

                path.remove(path.size()-1);
            }
        }
    }
    
    boolean canPlace(int k) {
        int row = path.size();
        for (int i=0; i<path.size(); i++) {
            int p = path.get(i);
            int forbid1 = p + (row-i);
            int forbid2 = p - (row-i);
            if (k == forbid1 || k == forbid2 || k == p)
                return false;
        }
        return true;
    }
}
