import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Valued Customer on 12/6/2016.
 * 给出飞机的起飞和降落时间的列表，用 interval 序列表示. 请计算出天上同时最多有多少架飞机？

 注意事项

 如果多架飞机降落和起飞在同一时刻，我们认为降落有优先权。

 样例
 对于每架飞机的起降时间列表：[[1,10],[2,3],[5,8],[4,7]], 返回3。
 */
public class p391 {

    public class Interval {
        public int start, end;
        public Interval(int b, int e) {
            start = b;
            end = e;
        }
    }

    public class Time {
        public int value;
        public boolean isStart;
        public Time(int v, boolean s) {
            value = v;
            isStart = s;
        }
    }

    public class TimeComparator implements Comparator<Time> {
        @Override
        public int compare(Time t1, Time t2) {
            return t1.value - t2.value;
        }
    }
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code
        int count = 0;
        if (airplanes.size() == 0) return count;
        if (airplanes.size() == 0) return count;
        List<Time> times = new ArrayList<>();
        for (Interval i : airplanes) {
            times.add(new Time(i.start, true));
            times.add(new Time(i.end, false));
        }
        Collections.sort(times, (Time a, Time b) -> a.value - b.value);
        int max = 0;
        for (Time t : times) {
            if (t.isStart) {
                count++;
                max = Math.max(max, count);
            } else {
                count--;
            }
        }
        return max;
    }
}
