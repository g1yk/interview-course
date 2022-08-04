class DfsMatrix {
    private val dir: Array<IntArray> =  arrayOf(intArrayOf(0, 1), intArrayOf(1,0), intArrayOf(0, -1), intArrayOf(-1, 0))
    
    fun dfs(grid: Array<IntArray>) {
        val visited = Array(grid.size) { BooleanArray(grid[0].size) }
        dfs(grid, 0, 0, visited)
    }
    
    private fun dfs(grid: Array<IntArray>, row: Int, col: Int, visited: Array<BooleanArray>) {
        if (row < 0 || row >= grid.size || col < 0 || col >= grid[0].size || visited[row][col]) { return }
        
        visited[row][col] = true        
        System.out.println(grid[row][col])
        
        for (i in 0..dir.size-1) {
            dfs(grid, row + dir[i][0], col + dir[i][1], visited)
        }
    }
}
