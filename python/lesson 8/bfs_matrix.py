from collections import deque
from typing import List


class Solution:
    def bfs(self, grid: List[List[int]]):
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        visited = [[False] * len(grid[0]) for i in range(len(grid))]
        
        queue = deque()
        visited[0][0] = True
        queue.append([0, 0])
        print(grid[0][0])
        
        while len(queue) > 0:
            current = queue.popleft()        
            for dir in dirs:
                row = current[0] + dir[0]
                col = current[1] + dir[1]
                if row >= 0 and row < len(grid) and col >= 0 and col < len(grid[0]) and not visited[row][col]:
                    visited[row][col] = True
                    queue.append([row, col])
                    print(grid[row][col])
