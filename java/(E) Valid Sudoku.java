public class Solution {
    List<HashSet<Integer>> occupiedInRow = new ArrayList<HashSet<Integer>>();
    List<HashSet<Integer>> occupiedInCol = new ArrayList<HashSet<Integer>>();
    List<HashSet<Integer>> occupiedInSqr = new ArrayList<HashSet<Integer>>();

    public boolean isValidSudoku(char[][] board) {
        for (int i=0; i<9; i++) {
            HashSet<Integer> set = new HashSet<Integer>();
            occupiedInRow.add(set);
            set = new HashSet<Integer>();
            occupiedInCol.add(set);
            set = new HashSet<Integer>();
            occupiedInSqr.add(set);
        }
        
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char c = board[i][j];
                if (c == '.')
                    continue;
                int n = Integer.parseInt("" + c);
                
                int idx = (i / 3) * 3 + (j / 3);
                if (occupiedInRow.get(i).contains(n) || occupiedInCol.get(j).contains(n) || occupiedInSqr.get(idx).contains(n))
                    return false;
                occupiedInRow.get(i).add(n);
                occupiedInCol.get(j).add(n);
                occupiedInSqr.get(idx).add(n);
            }
        }
        return true;
    }
}

