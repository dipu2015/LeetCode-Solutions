/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0)
            return result;

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        result.add(list);
        for (int i=2; i<=numRows; i++) {
            List<Integer> newList = new ArrayList<Integer>();
            newList.add(1);
            if (list.size() > 1) {
                for (int j=0; j<list.size()-1; j++)
                    newList.add(list.get(j) + list.get(j+1));
            }
            newList.add(1);
            list = newList;
            result.add(list);
        }
        return result;
    }
}
