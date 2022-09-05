class DfsGraph {
    public void dfs(DirectedGraph graph) {
        boolean[] visited = new boolean[graph.size()];
        for (int v = 0; v < graph.size(); v++) {
            dfs(graph, v, visited);
        }
    }
    
    private void dfs(DirectedGraph graph, int v, boolean[] visited) {
        if (visited[v]) return; 
        
        visited[v] = true;
        System.out.println(v);
        
        for (int w: graph.get(v)) {
           dfs(graph, w, visited);
        }
    }
}
