public class Solution {
    public int minCost(int[][] costs) {
        if (costs.length == 0)
            return 0;
            
        int[][] table = new int[costs.length][costs[0].length];
        for (int i=0; i<costs[0].length; i++)
            table[0][i] = costs[0][i];

        for (int i=1; i<costs.length; i++) {
            for (int j=0; j<costs[i].length; j++) {
                int min = Integer.MAX_VALUE;
                for (int k=0; k<table[i].length; k++) {
                    if (k == j)
                        continue;
                    if (table[i-1][k] < min)
                        min = table[i-1][k];
                }
                table[i][j] = costs[i][j] + min;
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i=0; i<costs[0].length; i++) {
            if (table[table.length-1][i] < min)
                min = table[table.length-1][i];
        }
        return min;
    }
}
