package algorithm.graph;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;

@Data
public class Graph {
    HashMap<Integer,Node> nodes;
    HashSet<Edge> edges;
}
