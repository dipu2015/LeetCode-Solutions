public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] table = new boolean[n][n];
        int max = 0;
        String str = "";
        for (int i=n-1; i>=0; i--) {
            for (int j=i; j<n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i >= j-1)
                        table[i][j] = true;
                    else
                        table[i][j] = table[i+1][j-1] ? true : false;
                    if (table[i][j] && (j-i) >= str.length())
                        str = s.substring(i, j+1);
                }
            }
        }
        return str;
    }
}
