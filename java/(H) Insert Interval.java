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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int start = intervals.size();
        for (int i=0; i<intervals.size(); i++) {
            if (intervals.get(i).start >= newInterval.start || intervals.get(i).end >= newInterval.start) {
                start = i;
                break;
            }
        }
        int end = -1;
        for (int i=intervals.size()-1; i>=0; i--) {
            if (intervals.get(i).end <= newInterval.end || intervals.get(i).start <= newInterval.end) {
                end = i;
                break;
            }
        }
        
        if (start == intervals.size())
            intervals.add(newInterval);
        else if (end == -1)
            intervals.add(0, newInterval);
        else if (start == end) {
            intervals.get(start).start = Math.min(intervals.get(start).start, newInterval.start);
            intervals.get(start).end = Math.max(intervals.get(end).end, newInterval.end);
        }
        else if (start > end)
            intervals.add(start, newInterval);
        else {
            intervals.get(start).start = Math.min(intervals.get(start).start, newInterval.start);
            intervals.get(start).end = Math.max(intervals.get(end).end, newInterval.end);
            for (int i=start+1; i<=end; i++) {
                intervals.remove(start+1); // remove elements in arraylist
            }
        }
        return intervals;
    }
}
