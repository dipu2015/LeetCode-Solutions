/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new CustomComparator());
        int idx = 0;
        while (idx < intervals.size()-1) {
            Interval i1 = intervals.get(idx);
            Interval i2 = intervals.get(idx+1);
            if (i1.end < i2.start)
                idx++;
            else {
                i1.end = Math.max(i1.end, i2.end);
                intervals.remove(i2);
            }
        }
        return new ArrayList<Interval>(intervals);
    }
    
    public class CustomComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }
}
