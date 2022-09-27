// https://leetcode.com/problems/n-queens/submissions/

function solveNQueens(n) {
    const result = [];
    const board = [...new Array(n)].map(() => [...new Array(n)].map(() => '.'));
    
    solveNQueensImpl(board, 0, result, new Set(), new Set(), new Set());
    
    return result;
}


function solveNQueensImpl(board, row, result, columns, diagonals, antiDiagonals) {
    if (row === board.length) {
        result.push(board.map((line) => line.join("")));
        return;
    }
    
    for (let col = 0; col < board[0].length; col++) {
        const diag = row - col;
        const antiDiag = row + col;

        if (columns.has(col) || diagonals.has(diag) || antiDiagonals.has(antiDiag)) continue;

        board[row][col] = 'Q';                
        columns.add(col);
        diagonals.add(diag);
        antiDiagonals.add(antiDiag);

        solveNQueensImpl(board, row + 1, result, columns, diagonals, antiDiagonals);

        board[row][col] = '.'; // backtrack
        columns.delete(col);
        diagonals.delete(diag);
        antiDiagonals.delete(antiDiag);
    }
}
