package algorithm.array;

import java.util.*;

/**
 * 一次遍历解决问题，避免O(n^2)的嵌套循环
 * 算法思路：前缀+哈希表优化
 * 算法时间复杂度O（n),空间复杂度O（n)
 */
public class SubArraySum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 7, 5};
        subarraySum(arr, 12);
    }

    public static void subarraySum(int[] arr, int k) {
        boolean hasSubArr = false;
        int pre = 0;
        HashMap<Integer, List<Integer>> pre2LeftIdxs = new HashMap<>();
        pre2LeftIdxs.put(0, new ArrayList<>(Arrays.asList(0)));
        for (int i = 0; i < arr.length; i++) {
            pre += arr[i];
            if (pre2LeftIdxs.containsKey(pre - k)) {
                hasSubArr = true;
                List<Integer> startIdxs = pre2LeftIdxs.get(pre - k);
                for (Integer startIdx : startIdxs) {
                    System.out.println(String.format("The sum of elements from position %d to position %d sum up to %d", startIdx + 2, i + 1, k));
                }
            }

            if (pre2LeftIdxs.containsKey(pre)) {
                pre2LeftIdxs.get(pre).add(i);
            } else {
                pre2LeftIdxs.put(pre, new ArrayList<>(Arrays.asList(i)));
            }
        }
        if (!hasSubArr) {
            System.out.println("no sub array sum to " + k);
        }
    }
}
