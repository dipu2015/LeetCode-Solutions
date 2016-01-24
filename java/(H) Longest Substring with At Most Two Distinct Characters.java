public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int max = 0;
        int start = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.size() < 2 || map.containsKey(c)) {
                map.put(c, i);
                continue;
            }

            int len = i - start;
            max = Math.max(max, len);

            char pc = s.charAt(i-1);
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getKey() != pc) {
                    start = entry.getValue() + 1;
                    map.remove(entry.getKey());
                    break;
                }
            }
            map.put(c, i);
        }
        int len = s.length() - start;
        max = Math.max(max, len);
        
        return max;
    }
}
