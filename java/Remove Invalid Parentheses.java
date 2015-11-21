public class Solution {
    
    //DFS + Pruning + prevent checking visited strings;
    public List<String> removeInvalidParentheses(String s) {
            
        List<String> results = new ArrayList<String>();

        HashSet<String> visited = new HashSet<String>();
        visited.add(s);
        Queue<String> queue = new LinkedList<String>();
        queue.add(s);

        boolean done = false;
        while(queue.size() > 0) {
            String str = queue.remove();

            int mis = misMatches(str);
            if(mis == 0) {
                results.add(str);
                done = true;
            }
            if (done)
                continue;
            
            for (int i=0; i<str.length(); i++) {
                if (str.charAt(i) != '(' && str.charAt(i) != ')')
                    continue;
                    
                String newStr = str.substring(0, i) + str.substring(i+1);
                int mis2 = misMatches(newStr);
                if (mis2 == 0) {
                    if (!results.contains(newStr))
                        results.add(newStr);
                }
                else if (mis2 < mis) {  // pruning
                    if (!visited.contains(newStr)) { // prevent checking visited strings
                        queue.add(newStr);
                        visited.add(newStr);
                    }
                }
            }
        }
        return results;
    }
    
    private int misMatches(String s) {
        int a = 0, b = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(')
                a++;
            else if (s.charAt(i) == ')') {
                if (a > 0)
                    a--;
                else
                    b++;
            }
        }
        return a + b;
    }
}

