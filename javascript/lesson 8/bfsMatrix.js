function bfs(grid) {
    const dir = [[0, 1], [1, 0], [0, -1], [-1, 0]];
    const visited = Array(grid.length);
    for (let i = 0; i < grid.length; i++) visited[i] = Array(grid[0].length);

    const queue = [[0, 0]];
    visited[0][0] = true;
    console.log(grid[0][0]);

    while (queue.length > 0) {
        const current = queue.shift();
        for (let i = 0; i < dir.length; i++) {
            const row = current[0] + dir[i][0];
            const col = current[1] + dir[i][1];                
            if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && !visited[row][col]) {
                visited[row][col] = true;
                queue.push([row, col]);
                console.log(grid[row][col]);
            }
        }
    }    
}
