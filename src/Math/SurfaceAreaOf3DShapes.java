package Math;

public class SurfaceAreaOf3DShapes {
    public int surfaceArea(int[][] grid) {
        int[] dr = new int[]{1,0,-1,0};
        int[] dc = new int[]{0,1,0,-1};

        int N = grid.length;
        int res = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] > 0) {
                    res += 2;
                    for (int k = 0; k < 4; k++) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        int nv = 0;
                        if (0 <= nr && nr <= N && 0 <= nc && nc <= N) {
                            nv = grid[nr][nc];
                            res += Math.max(grid[r][c] - grid[nr][nc], 0);
                        }
                    }
                }
            }
        }
        return res;
    }
}
