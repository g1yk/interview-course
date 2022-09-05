// https://leetcode.com/problems/course-schedule-ii/

class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val graph = DirectedGraph(numCourses)
        for (p in prerequisites) {
            graph.add(p[1], p[0])
        }
        return topologicalSort(graph)
    }
    
    fun topologicalSort(graph: DirectedGraph): IntArray {
        val stack = Stack<Int>()
        val visited = BooleanArray(graph.size())
        val marked = BooleanArray(graph.size())
        
        for (v in 0..graph.size() - 1) {
            if (!dfs(graph, v, visited, marked, stack)) return IntArray(0)
        }
        
        val result = IntArray(stack.size);
        var i = 0
        while (!stack.isEmpty()) {
            result[i] = stack.pop()
            i++
        }
        return result
    }
    
    fun dfs(graph: DirectedGraph, v: Int, visited: BooleanArray, marked: BooleanArray, stack: Stack<Int>): Boolean {
        if (marked[v]) return false
        if (visited[v]) return true
        
        marked[v] = true
        visited[v] = true
                
        for (w in graph.get(v)) {
            if (!dfs(graph, w, visited, marked, stack)) return false
        }
        
        stack.push(v)
        marked[v] = false
        
        return true
    }
    
    public class DirectedGraph(capacity: Int) {
        val adj = Array<LinkedList<Int>>(capacity)  { LinkedList<Int>() }

        fun get(v: Int): List<Int> = adj[v]

        fun add(v: Int, w: Int) {
            adj[v].add(w)
        }

        fun size() = adj.size
    }
}
