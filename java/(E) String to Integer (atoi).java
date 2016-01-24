public class Solution {
    
    private static final int maxDiv10 = Integer.MAX_VALUE / 10;
    
    public int myAtoi(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i >= str.length())
            return 0;

        char c = str.charAt(i);
        int sign = 1;
        if (c == '+') {
            i++;
        }
        else if (c == '-') {
            sign = -1;
            i++;
        }
        
        int v = 0;
        while(i < str.length() && Character.isDigit(str.charAt(i))) {
            int d = str.charAt(i) - '0';
            if (v > maxDiv10 || (v == maxDiv10 && d >= 8))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            v = v * 10 + d;
            i++;
        }
        
        return sign * v;
    }
}
