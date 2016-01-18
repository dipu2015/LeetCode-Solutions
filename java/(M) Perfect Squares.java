/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
*/

public class Solution {
    public int numSquares(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
            
        int num = n;
        int rst = n;
        for (int i=1; i*i<=n; i++) {
            int a = n / (i*i);
            int res = n % (i*i);
            int b = numSquares(res);
            rst = Math.min(rst, a + b);
        }
        return rst;
    }
}
