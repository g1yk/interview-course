# https://leetcode.com/problems/n-queens/submissions/

def solve_n_queens(n)
    result = []
    board = Array.new(n) { Array.new(n) { '.' } }
    
    solve_n_queens_impl(board, 0, result, Set.new, Set.new, Set.new)
    
    result
end

def solve_n_queens_impl(board, row, result, columns, diagonals, anti_diagonals)
    if row == board.length
        result.push(board.map { |line| line.join("") })
        return
    end
    
    (0.. board[0].length - 1).each do |col| 
        diag = row - col
        antiDiag = row + col

        next if columns.include?(col) || diagonals.include?(diag) || anti_diagonals.include?(antiDiag)

        board[row][col] = 'Q'
        columns.add(col)
        diagonals.add(diag)
        anti_diagonals.add(antiDiag)

        solve_n_queens_impl(board, row + 1, result, columns, diagonals, anti_diagonals)

        board[row][col] = '.' # backtrack
        columns.delete(col)
        diagonals.delete(diag)
        anti_diagonals.delete(antiDiag)
    end
end
