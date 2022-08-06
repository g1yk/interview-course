def traverse(graph)
    visited = Array.new(graph.size)
    (0..graph.size - 1).each { |v| bfs(graph, v, visited) unless visited[v] }
end

def bfs(graph, start, visited)
    queue = Queue.new

    visited[start] = true
    queue.push(start)
    puts(start)

    while !queue.empty?
        v = queue.shift()        
        graph.get(v).each do |w|
            next if visited[w]
            visited[w] = true
            queue.push(w)
            puts(w)
        end
    end 
end
