public class Solution {
    public boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<Character>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c))
                set.add(c);
            else
                set.remove(c);
        }
        return (set.size() <= 1);
    }
}
