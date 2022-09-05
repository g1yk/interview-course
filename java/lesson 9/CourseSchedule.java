// https://leetcode.com/problems/course-schedule-ii/

import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        DirectedGraph g = new DirectedGraph(numCourses);
        for (int[] p : prerequisites) {
            g.add(p[1], p[0]);
        }        
        return topologicalSort(g);
    }
    
    private int[] topologicalSort(DirectedGraph g) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[g.size()];
        boolean[] marked = new boolean[g.size()];
        
        for (int i = 0; i < g.size(); i++) {
            if (!dfs(g, i, visited, marked, stack)) { 
                return new int[0]; 
            }
        }
        
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i] = stack.pop();
            i++;
        }
        return result;
    }
    
    private boolean dfs(DirectedGraph g, int v, boolean[] visited, boolean[] marked, Stack<Integer> stack) {
        if (marked[v]) { return false; }
        if (visited[v]) { return true; }
        
        marked[v] = true;
        visited[v] = true;        
                
        for (int w : g.get(v)) {
            if (!dfs(g, w, visited, marked, stack)) return false;
        }
        
        stack.push(v);        
        marked[v] = false;
        
        return true;
    }
    
    private static class DirectedGraph {
        private List<Integer>[] adj;

        public DirectedGraph(int V) {
            adj = (List<Integer>[]) new ArrayList[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new ArrayList<Integer>();
            }
        }

        public List<Integer> get(int v) {
            return adj[v];
        }

         public void add(int v, int w) {
            adj[v].add(w);
        }

        public int size() {
            return adj.length;
        }
    }
}
