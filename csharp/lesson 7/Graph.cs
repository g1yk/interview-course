public class Graph
{
    private IList<int>[] adj;
    public int Size { get => adj.Length; }
    
    public Graph(int capacity) 
    {
        adj = new IList<int>[capacity];
        for (var i = 0; i < capacity; i++)
        {
            adj[i] = new List<int>();
        }
    }

    public void Add(int v, int w)
    {
        adj[v].Add(w);
        adj[w].Add(v);
    }

    public IList<int> Get(int v) 
    {
        return adj[v];
    }
}
