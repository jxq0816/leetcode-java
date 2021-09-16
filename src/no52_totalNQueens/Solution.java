package no52_totalNQueens;

import java.util.*;

public class Solution {
    public int totalNQueens(int n) {
        List<int[]> solutions = new ArrayList<int[]>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<Integer>();//每一列是否有皇后
        Set<Integer> diagonals1 = new HashSet<Integer>();//主对角斜线是否有皇后
        Set<Integer> diagonals2 = new HashSet<Integer>();//负对角斜线是否有皇后
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions.size();
    }
    //递归深度row控制棋盘的行，每一层里for循环的i控制棋盘的列，一行一列，确定了放置皇后的位置。
    public void backtrack(List<int[]> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            // 深度优先遍历到下标为 n，表示 [0.. n - 1] 已经填完，得到了一个结果
            solutions.add(queens);
        } else {
            // 针对行下标为row的每一列，尝试是否可以放置
            for (int i = 0; i < n; i++) {//行号
                if (columns.contains(i)) {
                    continue;//不能在同一列
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;//不能在同一斜线(主对角线方向)
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;//不能在同一斜线(负对角线方向)
                }
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }
}