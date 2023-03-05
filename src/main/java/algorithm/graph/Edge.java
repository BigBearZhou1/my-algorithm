package algorithm.graph;

import lombok.Data;

@Data
public class Edge {
    int weight;
    Node from;
    Node to;

    public Edge(int weight){
        this.weight = weight;
    }
}
