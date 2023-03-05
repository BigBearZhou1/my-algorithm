package algorithm.graph;

import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class Node {
    int value;
    int in;
    int out;
    List<Node> nexts;
    List<Edge> edges;

    public Node(int value){
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
