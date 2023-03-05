package algorithm.graph;

import java.util.*;

public class GraphDFS {
    public static List<List<Integer>> dfs(Node node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curRes = new ArrayList<>();
        process(node, curRes, res);
        return res;
    }

    private static void process(Node node, List<Integer> curRes, List<List<Integer>> res) {
        if (curRes.contains(node.value)) {
            ArrayList<Integer> tempRes = new ArrayList<>(curRes);
            tempRes.add(node.value);
            res.add(tempRes);
            return;
        }

        if (node.nexts.size() == 0) {
            curRes.add(node.value);
            res.add(new ArrayList<>(curRes));
            curRes.remove(curRes.size()-1);
            return;
        }
        curRes.add(node.value);
        for (Node next : node.nexts) {
            process(next, curRes, res);
        }
        curRes.remove(curRes.size()-1);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.nexts = Arrays.asList(n2, n3, n4);
        n2.nexts = Arrays.asList(n3, n5);
        n3.nexts = Arrays.asList(n1, n2, n4, n5);
        n4.nexts = new ArrayList<>();
        n5.nexts = new ArrayList<>();

        List<List<Integer>> dfs = GraphDFS.dfs(n1);
        System.out.println(dfs);

    }
}
