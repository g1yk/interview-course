function traverse(graph) {
    const visited = Array(graph.size());
    for (let v = 0; v < graph.size(); v++) {
        if (!visited[v]) bfs(graph, v, visited);
    }
}

function bfs(graph, start, visited) {
    const queue = [];
    
    visited[start] = true;
    queue.push(start);    
    console.log(start);
    
    while (queue.length > 0) {
        const v = queue.shift();
        for (let w of graph.get(v)) {
            if (!visited[w]) {
                visited[w] = true;
                queue.push(w);
                console.log(w);
            }
        }
    }
}
