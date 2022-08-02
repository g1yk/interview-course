class Graph
    def initialize(capacity)
        @adj = Array.new(capacity) { [] }
    end
    
    def size
        @adj.length
    end
    
    def get(v)
        @adj[v]
    end
    
    def add(v, w)
        @adj[v].push(w)
        @adj[w].push(v)
    end
end
