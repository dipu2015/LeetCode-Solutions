/*
Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?

Related problem: Rotate Array
*/

public class Solution {
    public void reverseWords(char[] s) {
        int start = 0;
        for (int i=0; i<=s.length; i++) {
            if (i == s.length || s[i] == ' ') {
                reversePart(s, start, i-1);
                start = i + 1;
            }
        }
        reversePart(s, 0, s.length - 1);
    }
    
    private void reversePart(char[] s, int start, int end) {
        while (start < end) {
            char t = s[start];
            s[start] = s[end];
            s[end] = t;
            start++;
            end--;
        }
    }
}
