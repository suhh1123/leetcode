package DFSBFS;

public class FriendCircles {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int res = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                res ++;
            }
        }
        return res;
    }

    private void dfs(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = false;
                dfs(M, visited, j);
            }
        }
    }
}
