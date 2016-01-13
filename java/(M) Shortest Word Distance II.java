/*
This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
*/

public class WordDistance {

    HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    
    public WordDistance(String[] words) {
        for (int i=0; i<words.length; i++) {
            List<Integer> list = map.get(words[i]);
            if (list == null)
                list = new ArrayList<Integer>();
            list.add(i);
            map.put(words[i], list);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        if (list1 == null || list2 == null)
            return -1;
        
        int p1 = 0;
        int p2 = 0;
        int min = Integer.MAX_VALUE;
        while(p1 < list1.size() && p2 < list2.size()) {
            int d = Math.abs(list1.get(p1) - list2.get(p2));
            if (d < min)
                min = d;

            if (list1.get(p1) < list2.get(p2))
                p1++;
            else
                p2++;
        }
        return min;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
