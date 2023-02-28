package algorithm.uniset;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFind<V> {
    public static class Node<V> {
        V value;

        public Node(V v) {
            this.value = v;
        }
    }

    private HashMap<V, Node<V>> nodes;
    private HashMap<Node<V>, Node<V>> parents;
    private HashMap<Node<V>, Integer> sizeMap;

    public UnionFind(List<V> elements) {
        this.nodes = new HashMap<>();
        this.parents = new HashMap<>();
        this.sizeMap = new HashMap<>();
        for (V elm : elements) {
            Node<V> node = new Node<>(elm);
            nodes.put(elm, node);
            parents.put(node, node);
            sizeMap.put(node, 1);
        }
    }

    public Node<V> findFather(Node<V> cur) {
        Stack<Node<V>> stack = new Stack<>();
        while (cur != parents.get(cur)) {
            stack.push(cur);
            cur = parents.get(cur);
        }
        while (!stack.isEmpty()) {
            parents.put(cur, stack.pop());
        }
        return cur;
    }

    public boolean isSameSet(V x, V y) {
        if (!nodes.containsKey(x) || !nodes.containsKey(y)) {
            return false;
        }
        return findFather(nodes.get(x)) == findFather(nodes.get(y));
    }

    public void union(V x, V y) {
        if (!nodes.containsKey(x) || !nodes.containsKey(y)) {
            return;
        }
        Node<V> nodeX = nodes.get(x);
        Node<V> nodeY = nodes.get(y);

        Node<V> fx = findFather(nodeX);
        Node<V> fy = findFather(nodeY);

        if(fx == fy){
            return;
        }

        if (sizeMap.get(fx) > sizeMap.get(fy)) {
            parents.put(fx, fy);
            sizeMap.put(fx, sizeMap.get(fx) + sizeMap.get(fy));
            sizeMap.remove(fy);
        } else {
            parents.put(fy, fx);
            sizeMap.put(fy, sizeMap.get(fy) + sizeMap.get(fx));
            sizeMap.remove(fx);
        }
    }
}
