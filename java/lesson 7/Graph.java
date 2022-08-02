import java.util.*;

public class Graph {
    private List<Integer>[] adj;
 
    public Graph(int capacity) {
        adj = (List<Integer>[]) new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }
    
    public List<Integer> get(int v) {
        return adj[v];
    }
    
     public void add(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }
    
    public int size() {
        return adj.length;
    }
}
