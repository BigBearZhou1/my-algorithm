package algorithm.graph;

import java.util.*;

public class GraphBFS {
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();

        queue.offer(node);
        set.add(node);

        int curLevelSize = 1;
        int nextLevelSize = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.value + " ");

            curLevelSize--;

            for (Node next : cur.nexts) {
                if(!set.contains(next)) {
                    set.add(next);
                    queue.offer(next);
                    nextLevelSize++;
                }
            }
            if(curLevelSize == 0){
                System.out.println();
                curLevelSize = nextLevelSize;
                nextLevelSize = 0;
            }
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.nexts = Arrays.asList(n2,n3,n4);
        n2.nexts = Arrays.asList(n3,n5);
        n3.nexts = Arrays.asList(n1,n2,n4,n5);
        n4.nexts = new ArrayList<>();
        n5.nexts = new ArrayList<>();

        GraphBFS.bfs(n1);

    }
}
