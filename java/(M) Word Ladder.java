public class Solution {

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == endWord)
            return 0;
            
        List<String> list = new ArrayList<String>();
        list.add(beginWord);
        wordList.remove(endWord);
        
        int level = 0;
        while(list.size() > 0) {
            level += 1;
            List<String> temp = new ArrayList<String>();
            
            for (String w : list) {
                List<String> trans = transform(w);
                for (String t : trans) {
                    if (t.equals(endWord))
                        return level + 1;
                    
                    if (wordList.contains(t)) {
                        temp.add(t);
                        wordList.remove(t);
                    }
                }
            }
            list = temp;
        }
        
        return 0;
    }
    
    private ArrayList<String> transform(String str) {
        ArrayList<String> trans = new ArrayList<String>();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != str.charAt(i)) {
                    arr[i] = c;
                    trans.add(new String(arr));
                }
            }
            arr[i] = str.charAt(i);
        }
        return trans;
    }
}
