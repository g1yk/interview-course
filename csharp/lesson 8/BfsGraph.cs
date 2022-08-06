public class BfsGraph
{
    public void Bfs(Graph graph)
    {
        var visited = new bool[graph.Size];
        for (var v = 0; v < graph.Size; v++)
        {
            if (!visited[v]) Bfs(graph, v, visited);
        }
    }

    private void Bfs(Graph graph, int start, bool[] visited)
    {
        var queue =  new Queue<int>();
        
        visited[start] = true;
        queue.Enqueue(start);
        Console.WriteLine(start);

        while (queue.Count > 0)
        {
            var v = queue.Dequeue();
            foreach (var w in graph.Get(v))
            {
                if (!visited[w])
                {
                    visited[w] = true;
                    queue.Enqueue(w);
                    Console.WriteLine(w);
                }
            }
        }
    }
}
