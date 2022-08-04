from typing import List


class Solution:
    def traverse(self, grid: List[List[int]]):
        visited = [[False] * len(grid[0]) for i in range(len(grid))]
        self.dfs(grid, 0, 0, visited)
    
    def dfs(self, grid: List[List[int]], row: int, col: int, visited: List[List[bool]]):
        if row < 0 or row >= len(grid) or col < 0 or col >= len(grid[0]) or visited[row][col]:
            return
        
        visited[row][col] = True
        print(grid[row][col])
        
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]        
        for dir in dirs:
            self.dfs(grid, row + dir[0], col + dir[1], visited)
