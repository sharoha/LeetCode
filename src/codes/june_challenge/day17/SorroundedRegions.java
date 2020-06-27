package codes.june_challenge.day17;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;
import library.util.MathUtil.IntegerUtil;

import static library.util.MathUtil.IntegerUtil.*;

public class SorroundedRegions {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.i();
        int m = in.i();
        char[][] u = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                u[i][j] = in.c();
            }
        }
        solve(u);
        for (int i = 0; i < n; i++) {
            out.printLine(u[i]);
        }
    }
    private boolean[][] vis;
    private int n, m;
    public void solve(char[][] board) {
        if (board.length == 0) return;
        n = board.length;
        m = board[0].length;
        vis = new boolean[n][m];
        // first row;
        for (int i = 0; i < m; i++) {
            if (!vis[0][i] && board[0][i] == 'O') {
                dfs(board, 0, i, 'O');
            }
        }

        // last row;
        for (int i = 0; i < m; i++) {
            if (!vis[n - 1][i] && board[n - 1][i] == 'O') {
                dfs(board, n - 1, i, 'O');
            }
        }

        // first column
        for (int i = 0; i < n; i++) {
            if (!vis[i][0] && board[i][0] == 'O') {
                dfs(board, i, 0, 'O');
            }
        }

        // last column
        for (int i = 0; i < n; i++) {
            if (!vis[i][m - 1] && board[i][m - 1] == 'O') {
                dfs(board, i, m - 1, 'O');
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && board[i][j] == 'O') {
                    dfs(board, i, j, 'X');
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y, char cur) {
        board[x][y] = cur;
        vis[x][y] = true;
        for (int i = 0; i < 4; i++) {
            if (isValid(x + dx4[i], y + dy4[i]) && board[x + dx4[i]][y + dy4[i]] == 'O') {
                dfs(board, x + dx4[i], y + dy4[i], cur);
            }
        }
    }

    private boolean isValid(int dx, int dy) {
        return dx >= 0 && dx < n && dy >= 0 && dy < m && !vis[dx][dy];
    }

}
