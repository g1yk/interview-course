function traverse(graph) {
    const visited = Array(graph.size());
    for (let v = 0; v < graph.size(); v++) {
        dfs(graph, v, visited);
    }
}

function dfs(graph, v, visited) {
    if (visited[v]) return; 

    visited[v] = true;
    console.log(v);

    for (let w of graph.get(v)) {
       dfs(graph, w, visited);
    }
}
