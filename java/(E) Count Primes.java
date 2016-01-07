public class Solution {
    public int countPrimes(int n) {
        int[] table = new int[n];
        int count = 0;
        for (int i=2; i<n; i++) {
            if (table[i] == 0) {
                count++;
                for (int j=1; j*i<n; j++)
                    table[j*i] = j*i;
            }
        }
        return count;
    }
}
