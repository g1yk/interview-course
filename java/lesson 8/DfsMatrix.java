class DfsMatrix {
    private static int[][] dir = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    
    public void dfs(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid, 0, 0, visited);
    }
    
    private void dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col]) { return; }
        
        visited[row][col] = true;        
        System.out.println(grid[row][col]);
        
        for (int i = 0; i < dir.length; i++) {
            dfs(grid, row + dir[i][0], col + dir[i][1], visited);
        }
    }
}
