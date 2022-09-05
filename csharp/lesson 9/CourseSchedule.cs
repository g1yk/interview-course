public class Solution 
{
    public int[] FindOrder(int numCourses, int[][] prerequisites) 
    {
        var graph = new DirectedGraph(numCourses);
        foreach (var p in prerequisites)
        {
            graph.Add(p[1], p[0]);
        }
        
        return topologicalSort(graph);
    }
    
    private int[] topologicalSort(DirectedGraph graph)
    {
        var visited = new bool[graph.Count];
        var marked = new bool[graph.Count];
        var stack = new Stack<int>();
            
        for (var v = 0; v < graph.Count; v++)
        {
            if (!dfs(graph, v, visited, marked, stack)) return Array.Empty<int>();
        }

        var result = new int[stack.Count];
        var i = 0;
        while (stack.Count > 0)
        {
            result[i] = stack.Pop();
            i++;
        }
        return result;
    }
        
    private bool dfs(DirectedGraph graph, int v, bool[] visited, bool[] marked, Stack<int> stack) 
    {
        if (marked[v]) return false;
        if (visited[v]) return true;

        marked[v] = true;
        visited[v] = true;
        
        foreach (var i in graph.Get(v))
        {   
            if (!dfs(graph, i, visited, marked, stack)) return false;
        }

        stack.Push(v);
        marked[v] = false;

        return true;
    }
    
    private class DirectedGraph
    {
        private IList<IList<int>> adj;
        
        public DirectedGraph(int count)
        {
            Count = count;
            adj = new List<IList<int>>(count);
            for (var i = 0; i < count; i++) { adj.Add(new List<int>()); }
        }
        
        public int Count 
        { 
            get;
            private set;
        }
        
        public IList<int> Get(int v) {
            return adj[v];
        }
        
        public void Add(int from, int to)
        {
            adj[from].Add(to);
        }
    }
}
