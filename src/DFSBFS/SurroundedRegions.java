package DFSBFS;

public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') boundaryDFS(board, i, 0);
            if (board[i][col - 1] == 'O') boundaryDFS(board, i, col - 1);
        }

        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') boundaryDFS(board, 0, j);
            if (board[row - 1][j] == 'O') boundaryDFS(board, row - 1, j);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '/') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void boundaryDFS(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '/';
        boundaryDFS(board, i + 1, j);
        boundaryDFS(board, i - 1, j);
        boundaryDFS(board, i, j + 1);
        boundaryDFS(board, i, j - 1);
    }
}
