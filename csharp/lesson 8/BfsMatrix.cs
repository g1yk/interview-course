public class BfsMatrix
{
    public void Bfs(int[][] grid)
    {
        var dir = new int[][] { new int[] {0, 1}, new int[] {1, 0}, new int[] {0, -1}, new int[] {-1, 0} };
        var visited = new bool[grid.Length][];
		for (int i = 0; i < visited.Length; i++)visited[i] = new bool[grid[0].Length];
        var queue = new Queue<int[]>();
        
        visited[0][0] = true;
        queue.Enqueue(new int[] {0, 0});
        Console.WriteLine(grid[0][0]);
        
        while (queue.Count > 0)
        {
            int[] current = queue.Dequeue();
            for (int i = 0; i < dir.Length; i++)
            {
                int row = current[0] + dir[i][0];
                int col = current[1] + dir[i][1];                
                if (row >= 0 && row < grid.Length && col >= 0 && col < grid[0].Length && !visited[row][col])
                {
                    visited[row][col] = true;
                    queue.Enqueue(new int[] { row, col });
                    Console.WriteLine(grid[row][col]);
                }
            }
        }
    }
}
