import java.util.LinkedList;
import java.util.Queue;

public class BfsGraph {
    public void bfs(Graph graph) {
        boolean[] visited = new boolean[graph.size()];
        for (int v = 0; v < graph.size(); v++) {
            if (!visited[v]) bfs(graph, v, visited);
        }
    }

    private void bfs(Graph graph, int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<Integer>();
        
        visited[start] = true;
        queue.add(start);
        System.out.println(start);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : graph.get(v)) {
                if (!visited[w]) {
                    visited[w] = true;
                    queue.add(w);
                    System.out.println(w);
                }
            }
        }
    }
}
