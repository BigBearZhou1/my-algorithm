package algorithm.graph;

import java.util.*;

/**
 * 图的拓扑排序算法
 * 要求：有向无环图
 * 应用：事件安排、编译顺序
 */
public class TopologySort {


    public static List<Node> sortedTopology(Graph graph) {
        // key：某一个node
        // value：剩余的入度
        HashMap<Node, Integer> node2In = new HashMap<>();

        // 入度为0的点，才能进这个队列
        Queue<Node> zeroInQueue = new LinkedList<>();

        // 拓扑排序的结果，依次加入result
        List<Node> result = new ArrayList<>();

        for (Node node : graph.nodes.values()) {
            if (node.in == 0) {
                zeroInQueue.offer(node);
            }
            node2In.put(node, node.in);
        }

        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                int newIn = node2In.get(next) - 1;
                node2In.put(next, newIn);
                if (newIn == 0) {
                    zeroInQueue.offer(next);
                }
            }
        }
        return result;
    }
}
