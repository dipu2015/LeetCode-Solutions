public class Solution {
    
    List<Integer> path = new ArrayList<Integer>();
    List<List<String>> result = new ArrayList<List<String>>();
    
    public List<List<String>> solveNQueens(int n) {
        helper(n);
        return result;
    }
    
    void helper(int n) {
        for (int i=0; i<n; i++) {
            if (canPlace(i)) {
                path.add(i);
                if (path.size() == n) {
                    // put it to results
                    List<String> solution = new ArrayList<String>();
                    for (int k=0; k<path.size(); k++) {
                        String str = "";
                        for (int l=0; l<n; l++) {
                            if (l!=path.get(k))
                                str = str + ".";
                            else
                                str = str + "Q";
                        }
                        solution.add(str);
                    }
                    result.add(solution);
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
