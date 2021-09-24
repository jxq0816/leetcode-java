package no200_numIslands;

public class Solution {
    int m,n;
    int cnt=0;
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        visited=new boolean[n][m];
        if(n==0){
            return 0;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==false){
                    visited[i][j]=true;
                    if(grid[i][j]=='1'){
                        dfs(grid,i,j);
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
    void dfs(char[][] grid,int i,int j){
        if(i+1<n&&visited[i+1][j]==false){
            visited[i+1][j]=true;
            if(grid[i+1][j]=='1'){
                dfs(grid,i+1,j);
            }
        }
        if(i-1>=0&&visited[i-1][j]==false){
            visited[i-1][j]=true;
            if(grid[i-1][j]=='1'){
                dfs(grid,i-1,j);
            }
        }
        if(j+1<m&&visited[i][j+1]==false){
            visited[i][j+1]=true;
            if(grid[i][j+1]=='1'){
                dfs(grid,i,j+1);
            }
        }
        if(j-1>=0&&visited[i][j-1]==false){
            visited[i][j-1]=true;
            if(grid[i][j-1]=='1'){
                dfs(grid,i,j-1);
            }
        }

    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        //char[][] grid={{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        Solution solution=new Solution();
        System.out.println(solution.numIslands(grid));
    }
}
