package algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeArray56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[1][2];
        }

        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);

        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[1][1];

            if (res.size() == 0 || res.get(res.size() - 1)[1] < l) {
                res.add(intervals[i]);
            } else {
                res.add(new int[]{res.get(res.size() - 1)[0], Math.max(res.get(res.size() - 1)[1], r)});
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
