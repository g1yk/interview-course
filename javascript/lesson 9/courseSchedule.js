// https://leetcode.com/problems/course-schedule-ii/

function findOrder(numCourses, prerequisites) {
    const graph = new DirectedGraph(numCourses);
    for (let p of prerequisites) {
        graph.add(p[1], p[0]);
    }
    return topologicalSort(graph);
}

function topologicalSort(graph) {
    const visited = Array(graph.size());
    const marked = Array(graph.size());
    const stack = [];
    
    for (let v = 0; v < graph.size(); v++) {
        if (!dfs(graph, v, visited, marked, stack)) return [];
    }
    
    return stack.reverse();
}

function dfs(graph, v, visited, marked, stack) {
    if (marked[v]) return false
    if (visited[v]) return true; 

    visited[v] = true;
    marked[v] = true;

    for (let w of graph.get(v)) {
       if (!dfs(graph, w, visited, marked, stack)) return false;
    }

    stack.push(v);
    marked[v] = false;
    
    return true;
}

class DirectedGraph {
    constructor(capacity) {
        this.adj = new Array(capacity);
        for (let i = 0; i < capacity; i++) {
            this.adj[i] = [];
        }
    }

    get(v) {
        return this.adj[v];
    }

    add(v, w) {
        this.adj[v].push(w);
    }

    size() {
        return this.adj.length;
    }
}
