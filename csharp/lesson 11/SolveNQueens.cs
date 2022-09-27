// https://leetcode.com/problems/n-queens/submissions/

public class Solution {
    public IList<IList<string>> SolveNQueens(int n) {
        var result = new List<IList<string>>();
        
        char[][] board = new char[n][];
        for (var row = 0; row < n; row++)
        {
            board[row] = new char[n];
            for (var col = 0; col < n; col++)
                board[row][col] = '.';
        }
            
        SolveNQueens(board, 0, result, new HashSet<int>(), new HashSet<int>(), new HashSet<int>());
        return result;
    }
    
    private void SolveNQueens(char[][] board, int row, IList<IList<string>> result, ISet<int> columns, ISet<int> diagonals, ISet<int> antiDiagonals)
    {
        if (row == board.Length)
        {
            result.Add(ToResult(board));
            return;
        }
        
        for (int col = 0; col < board[0].Length; col++)
        {
            var diag = row - col;
            var antiDiag = row + col;
            
            if (columns.Contains(col) || diagonals.Contains(diag) || antiDiagonals.Contains(antiDiag)) continue;            
            
            board[row][col] = 'Q';                
            columns.Add(col);
            diagonals.Add(diag);
            antiDiagonals.Add(antiDiag);
            
            SolveNQueens(board, row + 1, result, columns, diagonals, antiDiagonals);
            
            board[row][col] = '.'; // backtrack
            columns.Remove(col);
            diagonals.Remove(diag);
            antiDiagonals.Remove(antiDiag);
        }
    }
    
    
    private IList<string> ToResult(char[][] board)
    {
        var result = new List<string>();
        for (int i = 0; i < board.Length; i++)
        {
            result.Add(new String(board[i]));
        }
        return result;
    }
}
