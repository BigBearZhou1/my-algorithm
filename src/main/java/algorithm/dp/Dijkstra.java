package algorithm.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 图中一个点到其他点的最小距离
 * dijkstra 迪克特斯拉算法
 * 从现有的最短路径推出到下层各个点的最短路径
 */
public class Dijkstra {
    public static HashMap<Node, Integer> dijkstra1(Node from) {
        //记录from到各个点的最短路径
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        //初始化时，就是from自己到自己
        distanceMap.put(from, 0);

        //已经走过一次的点就不要重复作为新的起点了
        HashSet<Node> selectedNodes = new HashSet<>();
        //获取当前从开始到现在最短的点
        Node minNode = getMinNode(distanceMap, selectedNodes);

        while (minNode != null) {
            Integer distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node to = edge.to;
                //到达了新的点
                if (!distanceMap.containsKey(to)) {
                    distanceMap.put(to, distance + edge.weight);
                } else {/*之前已经有到达的点要比较总路径长短，路径更短才会更新*/
                    distanceMap.put(to, Math.min(distanceMap.get(to), distance + edge.weight));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    private static Node getMinNode(HashMap<Node, Integer> distanceMap, HashSet<Node> selectedNodes) {
        Node minNode = null;
        int minVal = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node key = entry.getKey();
            Integer value = entry.getValue();
            if (!selectedNodes.contains(key) && value < minVal) {
                minNode = key;
                minVal = value;
            }
        }
        return minNode;
    }
}
