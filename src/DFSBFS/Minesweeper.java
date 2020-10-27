package DFSBFS;

public class Minesweeper {
    int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0], c = click[1];
        // If a mine ('M') is revealed, then the game is over - change it to 'X'
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        }

        // If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively
        dfs(board, r, c);
        return board;
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'E') {
            return;
        }
        int num = numOfBombs(board, r, c);
        if (num == 0) { // no adjacent mines
            board[r][c] = 'B';
            for (int k = 0; k < 8; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                dfs(board, nr, nc);
            }
        } else { // at least one adjacent mine
            board[r][c] = (char) ('0' + num);
        }
    }

    private int numOfBombs(char[][] board, int r, int c) {
        int res = 0;
        for (int k = 0; k < 8; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length) continue;
            if (board[nr][nc] == 'M' || board[nr][nc] == 'X') res ++;
        }
        return res;
    }
}
