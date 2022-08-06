def traverse(graph)
    visited = Array.new(graph.size)
    (0..graph.size - 1).each { |v| dfs(graph, v, visited) }
end

def dfs(graph, v, visited)
    return if visited[v]

    visited[v] = true
    puts(v)

    graph.get(v).each { |w| dfs(graph, w, visited) }
end
