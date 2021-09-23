package no130_solve;

public class Solution {
    int n, m;
    public void solve(char[][] board) {
        n = board.length;//行
        if (n == 0) {
            return;
        }
        m = board[0].length;//列
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 从边缘o开始搜索
                boolean isEdge = (i == 0 || j == 0 || i == n-1 || j == m-1);
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //board[i][j] == '#' 边界上的O,或者与之连通的O,不需要改变
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    //寻找边界上的O,或者与之连通的O
    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
            return;
        }
        board[x][y] = '#';//边界上的O与与之连通的0特殊处理
        dfs(board, x + 1, y);//下
        dfs(board, x - 1, y);//上
        dfs(board, x, y + 1);//右
        dfs(board, x, y - 1);//左
    }
}
