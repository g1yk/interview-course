class DfsGraph
{
    public void Dfs(Graph graph)
    {
        var visited = new bool[graph.Size];
        for (var v = 0; v < graph.Size; v++)
        {
            Dfs(graph, v, visited);
        }
    }
    
    private void Dfs(Graph graph, int v, bool[] visited)
    {
        if (visited[v]) return;
        
        visited[v] = true;
        Console.WriteLine(v);
        
        foreach (var w in graph.Get(v))
        {
           Dfs(graph, w, visited);
        }
    }
}
