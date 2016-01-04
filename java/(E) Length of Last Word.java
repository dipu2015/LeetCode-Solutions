public class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        int lastLen = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ')
                len++;
            else {
                if (len != 0)
                    lastLen = len;
                len = 0;
            }
        }
        return ( len != 0 ? len : lastLen );
    }
}
