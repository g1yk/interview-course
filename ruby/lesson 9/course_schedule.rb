# https://leetcode.com/problems/course-schedule-ii/

def find_order(num_courses, prerequisites)
    graph = DirectedGraph.new(num_courses)
    prerequisites.each { |p| graph.add(p[1], p[0]) }
    topological_sort(graph)
end

def topological_sort(graph)
    visited = Array.new(graph.size())
    marked = Array.new(graph.size())
    stack = []
    
    (0..graph.size - 1).each { |v| return [] unless dfs(graph, v, visited, marked, stack) }
    
    stack.reverse
end

def dfs(graph, v, visited, marked, stack)
    return false if marked[v]
    return true if visited[v]

    visited[v] = true
    marked[v] = true
    
    graph.get(v).each { |w| return false unless dfs(graph, w, visited, marked, stack) }
    
    stack.push(v)
    marked[v] = false
    
    true
end

class DirectedGraph
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
    end
end
