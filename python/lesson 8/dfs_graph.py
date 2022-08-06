class DfsGraph:
    def traverse(self, graph: Graph):
        visited = [False] * (graph.size())
        for v in range(0, graph.size() - 1):
            self.dfs(graph, v, visited)
            
    def dfs(self, graph: Graph, v: int, visited: List[bool]):
        if visited[v]:
            return
        
        visited[v] = True
        print(v)
        
        for w in graph.get(v):
            self.dfs(graph, w, visited)
