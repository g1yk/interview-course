def bfs(grid)
    dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    visited = Array.new(grid.length) { [] }

    queue = Queue.new
    queue.push([0, 0])
    visited[0][0] = true
    puts(grid[0][0])

    while !queue.empty?
        current = queue.shift()
        dirs.each do |(dx, dy)|
            row = current[0] + dx
            col = current[1] + dy
            if row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && !visited[row][col]
                visited[row][col] = true
                queue.push([row, col])
                puts(grid[row][col])
            end
        end
    end
end
