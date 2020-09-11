package 数组操作.q56_合并区间;


import org.junit.Test;

import java.util.*;

public class Solution2 {


    @Test
    public void test() {
        ArrayList<Interval> intervals = new ArrayList<>(Arrays.asList(new Interval(1, 3),
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(15, 18)));
        System.out.println(merge(intervals));
    }
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, (v1, v2) -> v1.start - v2.start);
        ArrayList<Interval> res = new ArrayList<>();

        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (res.isEmpty()) {
                res.add(interval);
            } else {
                Interval item = res.get(res.size() - 1);
                if (item.end < interval.start) {
                    res.add(interval);
                }
                else {
                    item.end = Math.max(item.end, interval.end);
                }
            }
        }
        return res;
    }




}
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
