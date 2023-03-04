package algorithm.greedy;

import io.netty.util.internal.StringUtil;

import java.util.ArrayList;

public class MinLight {
    public int minLight(String lightStr) {
        if (StringUtil.isNullOrEmpty(lightStr)) {
            return 0;
        }
        return process(lightStr.toCharArray(), 0, new ArrayList<Integer>());
    }

    private int process(char[] streetArray, int idx, ArrayList<Integer> lights) {
        if (idx == streetArray.length) {
            for (int i = 0; i < streetArray.length; i++) {
                if (streetArray[i] == '.') {
                    if (!lights.contains(i - 1) && !lights.contains(i) && !lights.contains(i + 1)) {
                        return Integer.MAX_VALUE;
                    }
                }
            }
            return lights.size();
        } else {
            int no = process(streetArray, idx + 1, lights);
            int yes = Integer.MAX_VALUE;
            if (streetArray[idx] == '.') {
                lights.add(idx);
                yes = process(streetArray, idx + 1, lights);
                lights.remove(idx);
            }
            return Math.max(no, yes);
        }
    }
}
