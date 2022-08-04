def traverse(grid)
    visited = Array.new(grid.length) { [] }
    dfs(grid, 0, 0, visited)
end

def dfs(grid, row, col, visited)
    return if row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col]
  
    visited[row][col] = true
    puts(grid[row][col])
  
    dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    dirs.each do |(dx, dy)|
        dfs(grid, row + dx, col + dy, visited)
    end
end
