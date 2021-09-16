package no79_exist;

public class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                boolean flag=dfs(board,visited,i,j,word,0);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }
    boolean dfs(char[][] board, boolean[][] visited, int i, int j, String s, int k){

        if(board[i][j]!=s.charAt(k)){
            return false;
        }else if(k==s.length()-1){
            return true;
        }
        visited[i][j]=true;
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        boolean rs=false;
        for(int[] dir:directions){
            int newi=i+dir[0];
            int newj=j+dir[1];
            if(newi>=0&&newi<board.length&&newj>=0&&newj<board[0].length){
                if(!visited[newi][newj]){
                    boolean flag=dfs(board,visited,newi,newj,s,k+1);
                    if(flag){
                        rs=true;
                        break;
                    }
                }
            }
        }
        visited[i][j]=false;//回溯
        return rs;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        Solution solution=new Solution();
        System.out.println(solution.exist(board,word));
    }
}
