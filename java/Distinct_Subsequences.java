public class Solution {
    //     r a b b b i t (s)
    //   1 1 1 1 1 1 1 1
    // r 0 1 1 1 1 1 1 1
    // a 0 0 1 1 1 1 1 1
    // b 0 0 0 1 2 3 3 3
    // b 0 0 0 0 1 3 3 3
    // i 0 0 0 0 0 0 3 3
    // t 0 0 0 0 0 0 0 3  
    // (t)
    // http://blog.csdn.net/abcbc/article/details/8978146
    
    public int numDistinct(String s, String t) {
        int[][] table = new int[t.length()+1][s.length()+1];
        
        for (int i=0; i<=t.length(); i++)
            table[i][0] = 0;
        for (int j=0; j<=s.length(); j++)
            table[0][j] = 1;

        for (int i=1; i<=t.length(); i++) {
            for (int j=1; j<=s.length(); j++) {
                if (t.charAt(i-1) == s.charAt(j-1))
                    table[i][j] = table[i-1][j-1] + table[i][j-1];
                else
                    table[i][j] = table[i][j-1];
            }
        }
        return table[t.length()][s.length()];
    }
}

