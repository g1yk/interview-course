# https://leetcode.com/problems/course-schedule-ii/

class DirectedGraph:
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
        
class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        graph = DirectedGraph(numCourses)
        for p in prerequisites:
            graph.add(p[1], p[0])
        return self.topologicalSort(graph)
    
    def topologicalSort(self, graph: DirectedGraph) -> List[int]:
        visited = [False] * (graph.size())
        marked = [False] * (graph.size())
        stack = []

        for v in range(0, graph.size()):
            if not self.dfs(graph, v, visited, marked, stack): return []
            
        return reversed(stack)
            
    def dfs(self, graph: DirectedGraph, v: int, visited: List[bool], marked: List[bool], stack: List[int]) -> bool:
        if marked[v]: return False
        if visited[v]: return True
        
        visited[v] = True
        marked[v] = True
        
        for w in graph.get(v):
            if not self.dfs(graph, w, visited, marked, stack): return False

        stack.append(v)
        marked[v] = False
        
        return True
