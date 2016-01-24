public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int start = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) >= start) {
                    max = Math.max(max, i - start);
                    start = map.get(c) + 1;
                }
            }
            map.put(c, i);
        }
        int len = s.length() - start;
        max = Math.max(max, len);
        
        return max;
    }
}
