function traverse(grid) {
  const visited = Array(grid.length);
  for (let i = 0; i < grid.length; i++) visited[i] = Array(grid[0].length);

  dfs(grid, 0, 0, visited);
}

function dfs(grid, row, col, visited) {
  if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col]) { return; }

  visited[row][col] = true;
  console.log(grid[row][col]);

  const dir = [[0, 1], [1, 0], [0, -1], [-1, 0]];
  for (let i = 0; i < dir.length; i++) {
    dfs(grid, row + dir[i][0], col + dir[i][1], visited);
  }
}
