class BfsGraph:
    def traverse(self, graph: Graph):
        visited = [False] * (graph.size())
        for v in range(0, graph.size() - 1):
            if not visited[v]:
                self.bfs(graph, v, visited)
            
    def bfs(self, graph: Graph, start: int, visited: List[bool]):
        queue = deque()
        
        visited[start] = True
        queue.append(start)
        print(start)
        
        while len(queue) > 0:
            v = queue.popleft()
            for w in graph.get(v):
                if not visited[w]:
                    visited[w] = True
                    queue.append(w)
                    print(w)
