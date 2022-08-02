class Graph:
    def __init__(self, capacity: int):
        self.adj = [[]] * (capacity)
        for i in range(0, capacity-1):
            self.adj[i] = []
        
    def size(self) -> int:
        return len(self.adj)
    
    def get(self, v: int) -> List[int]:
        return self.adj[v]
    
    def add(self, v: int, w: int):
        self.adj[v].append(w)
        self.adj[w].append(v)
