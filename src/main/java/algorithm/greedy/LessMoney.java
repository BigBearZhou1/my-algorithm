package algorithm.greedy;

import java.util.PriorityQueue;

/**
 * 分割黄金问题
 */
public class LessMoney {
    public int lessMoney1(int[] arr) {
        return doFindLessMoney(arr, 0);
    }

    private int doFindLessMoney(int[] arr, int curMoney) {
        if (arr.length == 1) {
            return curMoney;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                min = Math.min(doFindLessMoney(copyArrayButExcept(arr, i, j),
                        curMoney + arr[i] + arr[j]), min);
            }
        }
        return min;
    }

    private int[] copyArrayButExcept(int[] arr, int i, int j) {
        int[] next = new int[arr.length - 1];
        int cur = 0;
        for (int m = 0; m < arr.length; m++) {
            if (m != i && m != j) {
                next[cur++] = arr[m];
            }
        }
        next[cur] = arr[i] + arr[j];
        return next;
    }

    public int lessMoney2(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        int sum = 0;
        int newElm = 0;
        while (queue.size() > 1) {
            newElm = queue.poll() + queue.poll();
            sum += newElm;
            queue.offer(newElm);
        }
        return sum;
    }
}
