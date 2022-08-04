class DfsMatrix
{
    private static int[][] dir = { new int[] { 0, 1 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { -1, 0 } };

    public void Dfs(int[][] grid)
    {
        var visited = new bool[grid.Length][];
        for (int i = 0; i < visited.Length; i++) visited[i] = new bool[grid[0].Length];
        Dfs(grid, 0, 0, visited);
    }

    private void Dfs(int[][] grid, int row, int col, bool[][] visited)
    {
        if (row < 0 || row >= grid.Length || col < 0 || col >= grid[0].Length || visited[row][col]) { return; }

        visited[row][col] = true;
        Console.WriteLine(grid[row][col]);

        for (var i = 0; i < dir.Length; i++)
        {
            Dfs(grid, row + dir[i][0], col + dir[i][1], visited);
        }
    }
}
