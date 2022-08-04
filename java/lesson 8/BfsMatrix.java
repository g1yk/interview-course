import java.util.LinkedList;
import java.util.Queue;

public class BfsMatrix {
    public void bfs(int[][] grid) {
        int[][] dir = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        
        visited[0][0] = true;
        queue.add(new int[] {0, 0});
        System.out.println(grid[0][0]);
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();            
            for (int i = 0; i < dir.length; i++) {
                int row = current[0] + dir[i][0];
                int col = current[1] + dir[i][1];                
                if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && !visited[row][col]) {
                    visited[row][col] = true;
                    queue.add(new int[] { row, col });
                    System.out.println(grid[row][col]);
                }
            }
        }
    }
}
