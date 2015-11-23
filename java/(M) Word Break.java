/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s==null)
            return false;
            
        boolean[] table = new boolean[s.length() + 1];
        table[0] = true;
        for (int i=1; i<=s.length(); i++) {
            for (int j=0; j<i; j++) {
                String str = s.substring(j, i);
                if (table[j] && wordDict.contains(str)) {
                    table[i] = true;
                    break;
                }
            }
        }
        return table[s.length()];
    }
}

