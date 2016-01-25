public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] table = new int[m][n];
        for (int i=0; i<m; i++) {
            if (obstacleGrid[i][0] == 1)
                break;
            table[i][0] = 1;
        }
        for (int i=0; i<n; i++) {
            if (obstacleGrid[0][i] == 1)
                break;
            table[0][i] = 1;
        }
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (obstacleGrid[i][j] != 1)
                    table[i][j] = table[i-1][j] + table[i][j-1];
                // if (obstacleGrid[i-1][j] != 1)
                //     table[i][j] += table[i-1][j];
                // if (obstacleGrid[i][j-1] != 1)
                //     table[i][j] += table[i][j-1];
            }
        }
        return table[m-1][n-1];
    }
}
