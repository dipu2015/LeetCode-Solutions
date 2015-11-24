public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() == 1)
            return s1.equals(s2);
        
        // sort to speed up.
        char[] s1ch = s1.toCharArray();
        Arrays.sort(s1ch);
        String s1Sort = new String(s1ch);
        
        char[] s2ch = s2.toCharArray();
        Arrays.sort(s2ch);
        String s2Sort = new String(s2ch);
        
        if (!s1Sort.equals(s2Sort)) {
            return false;
        }

        for (int i=0; i<s1.length()-1; i++) {
            String s11 = s1.substring(0, i+1);
            String s12 = s1.substring(i+1);

            String s21 = s2.substring(0, i+1);
            String s22 = s2.substring(i+1);
            if (isScramble(s11, s21) && isScramble(s12, s22))
                return true;

            s21 = s2.substring(0, s2.length()-i-1);
            s22 = s2.substring(s2.length()-i-1);
            if (isScramble(s11, s22) && isScramble(s12, s21))
                return true;
        }
        return false;
    }
}
