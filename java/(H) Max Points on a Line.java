/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length == 0)
            return 0;
        else if (points.length == 1)
            return 1;
        
        int result = 0;

        for (int i=0; i<points.length; i++) {
            Point p = points[i];
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            int sameLoc = 1;
            
            for (int j=0; j<points.length; j++) {
                if (j == i)
                    continue;
                    
                Point p2 = points[j];
                if (p2.x == p.x && p2.y == p.y) {
                    sameLoc ++;
                    continue;
                }
                
                double dx = p2.x-p.x;
                double dy = p2.y-p.y;
                double r = Double.MAX_VALUE;
                if (p2.y != p.y)
                    r = dx / dy;

                if (!map.containsKey(r))
                    map.put(r, 1);
                else
                    map.put(r, map.get(r) + 1);
            }
            
            int maxNum = 0;
            for (Map.Entry<Double, Integer> entry : map.entrySet()) {
                int num = entry.getValue();
                if (num > maxNum)
                    maxNum = num;
            }
            maxNum += sameLoc;
            if (maxNum > result)
                result = maxNum;
        }

        return result;
    }
}
