public class Solution {

    final int INF = 2147483647;

    public void wallsAndGates(int[][] rooms) {

        List<int[]> list = new ArrayList<int[]>();
        for (int i=0; i<rooms.length; i++) {
            for (int j=0; j<rooms[0].length; j++) {
                if (rooms[i][j] == 0)
                    list.add(new int[]{i, j});
            }
        }
        
        int level = 0;
        while(!list.isEmpty()) {
            List<int[]> temp = new ArrayList<int[]>();
            for (int[] pos : list) {
                int i = pos[0];
                int j = pos[1];
                rooms[i][j] = Math.min(rooms[i][j], level);
                
                List<int[]> neighbors = new ArrayList<int[]>();
                neighbors.add(new int[]{i-1, j});
                neighbors.add(new int[]{i+1, j});
                neighbors.add(new int[]{i, j-1});
                neighbors.add(new int[]{i, j+1});
                for (int[] p : neighbors) {
                    if (p[0] < 0 || p[0] >= rooms.length || p[1] < 0 || p[1] >= rooms[0].length)
                        continue;
                    if (rooms[p[0]][p[1]] == INF)
                        temp.add(new int[]{p[0], p[1]});
                }
            }
            list = temp;
            level++;
        }
    }
}
