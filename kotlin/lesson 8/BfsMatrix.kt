class BfsMatrix {
    private val dir: Array<IntArray> =  arrayOf(intArrayOf(0, 1), intArrayOf(1,0), intArrayOf(0, -1), intArrayOf(-1, 0))
    
    fun bfs(grid: Array<IntArray>) {
        val visited = Array(grid.size) { BooleanArray(grid[0].size) }
        val queue = LinkedList<IntArray>()
        
        visited[0][0] = true
        queue.add(intArrayOf(0, 0))
        System.out.println(grid[0][0])
        
        while (!queue.isEmpty()) {
            val current = queue.poll();            
            for (i in 0..dir.size-1) {
                val row = current[0] + dir[i][0]
                val col = current[1] + dir[i][1]                
                if (row >= 0 && row < grid.size && col >= 0 && col < grid[0].size && !visited[row][col]) {
                    visited[row][col] = true
                    queue.add(intArrayOf(row, col))
                    System.out.println(grid[row][col])
                }
            }
        }
    }    
}
