import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int temp_length = 0;
        int new_begin = -1;
        Map<Character, Integer> dict = new HashMap<Character, Integer>(); // Character
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (dict.get(c) != null) {
                int idx = dict.get(c);
                if (idx >= new_begin) {
                    temp_length = i - idx;
                    if (temp_length > max)
                        max = temp_length;
                    dict.put(c, i);
                    new_begin = idx + 1;
                    continue;
                }
            }
            dict.put(c, i);
            temp_length++;
            if (temp_length > max)
                max = temp_length;
        }
        return max;
    }
}
