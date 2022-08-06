public class BfsGraph {
    fun bfs(graph: Graph) {
        val visited = BooleanArray(graph.size())
        for (v in 0..graph.size() - 1) {
            if (!visited[v]) bfs(graph, v, visited)
        }
    }

    private fun bfs(graph: Graph, start: Int, visited: BooleanArray) {
        val queue = LinkedList<Int>()
        
        visited[start] = true
        queue.add(start)
        System.out.println(start)

        while (!queue.isEmpty()) {
            val v = queue.poll()
            for (w in graph.get(v)) {
                if (!visited[w]) {
                    visited[w] = true
                    queue.add(w)
                    System.out.println(w)
                }
            }
        }
    }
}
