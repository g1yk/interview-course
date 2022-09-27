# https://leetcode.com/problems/n-queens/submissions/

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []
        board = [ [ '.' for row in range(n) ] for col in range(n) ]
        
        self.solveNQueensImpl(board, 0, result, set(), set(), set())
        return result
        
        
    def solveNQueensImpl(self, board: List[List[chr]], row: int, result: List[List[str]], columns: Set[int], diagonals: Set[int], antiDiagonals: Set[int]):
        if row == len(board):
            result.append(["".join(line) for line in board])
            return
        
        for col in range(len(board[0])):
            diag = row - col
            antiDiag = row + col
            
            if col in columns or diag in diagonals or antiDiag in antiDiagonals: continue
                
            board[row][col] = 'Q'
            columns.add(col)
            diagonals.add(diag)
            antiDiagonals.add(antiDiag)

            self.solveNQueensImpl(board, row + 1, result, columns, diagonals, antiDiagonals)

            board[row][col] = '.' # backtrack
            columns.remove(col)
            diagonals.remove(diag)
            antiDiagonals.remove(antiDiag)