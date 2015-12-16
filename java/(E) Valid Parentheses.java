public class Solution {
    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<Character> ();
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '[' || str.charAt(i) == '(' || str.charAt(i) == '{') {
                stack.push(str.charAt(i));
            }
            else {
                if (stack.isEmpty())
                    return false;
                char c = stack.peek();
                if ( (str.charAt(i) == ']' && c == '[') ||
                     (str.charAt(i) == ')' && c == '(') || 
                     (str.charAt(i) == '}' && c == '{') ) {
                    stack.pop();
                }
                else
                    return false;
            }
        }
        return stack.empty();
    }
}
