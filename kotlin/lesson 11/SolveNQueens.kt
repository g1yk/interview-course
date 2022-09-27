// https://leetcode.com/problems/n-queens/submissions/

class Solution {
    fun solveNQueens(n: Int): List<List<String>> {
        val result = mutableListOf<List<String>>()
        
        val board = Array(n) { CharArray(n) {'.'} }
        solveNQueens(board, 0, result, mutableSetOf<Int>(), mutableSetOf<Int>(), mutableSetOf<Int>())

        return result
    }
    
    fun solveNQueens(board: Array<CharArray>, row: Int, result: MutableList<List<String>>, columns: MutableSet<Int>, diagonals: MutableSet<Int>, antiDiagonals: MutableSet<Int>) {
        if (row == board.size) {
            result.add(toResult(board))
            return
        } 
        
        for (col in 0..board[0].size - 1) {
            val diag = row - col
            val antiDiag = row + col
            
            if (columns.contains(col) || diagonals.contains(diag) || antiDiagonals.contains(antiDiag)) continue
            
            board[row][col] = 'Q'
            columns.add(col)
            diagonals.add(diag)
            antiDiagonals.add(antiDiag)
            
            solveNQueens(board, row + 1, result, columns, diagonals, antiDiagonals)
            
            board[row][col] = '.' // backtrack
            columns.remove(col)
            diagonals.remove(diag)
            antiDiagonals.remove(antiDiag)
        }
    }
    
    private fun toResult(board: Array<CharArray>): List<String> {
        val result = mutableListOf<String>()
        for (line in board) {
            result.add(String(line))
        }
        return result
    }
}
