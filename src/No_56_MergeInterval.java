import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class No_56_MergeInterval {

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<=1) return intervals;
        //intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        Collections.sort(intervals, (c1, c2) -> (c1.start - c2.start));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> res = new LinkedList<>();
        for(Interval interval : intervals) {
            if(interval.start<=end) {
                end = Math.max(interval.end, end);
            } else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}
