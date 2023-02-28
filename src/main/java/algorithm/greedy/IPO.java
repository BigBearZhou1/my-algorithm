package algorithm.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    private class Program {
        int p;
        int c;

        public Program(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    private class MinCostComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.c - o2.c;
        }
    }

    private class MaxProfitComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o2.p - o1.p;
        }
    }

    public int findMaximizedCapital(int K, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Program> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Program> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());

        for (int i = 0; i < Profits.length; i++) {
            minCostQ.add(new Program(Profits[i], Capital[i]));
        }

        for (int i = 0; i < K; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().c < W) {
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.size() == 0) {
                return W;
            }
            W += maxProfitQ.poll().p;
        }
        return W;
    }
}
