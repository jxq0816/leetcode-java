package no174_calculateMinimumHP;

import java.util.*;

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        List<List<Integer>> paths=new ArrayList<List<Integer>>();
        List<Integer> path=new ArrayList<Integer>();
        path.add(dungeon[0][0]);
        dfs(0,0,dungeon,path,paths);
        int rs=Integer.MAX_VALUE;
        for(List<Integer> list:paths){
            int sum=0;
            int s=0;
            for(Integer v:list){
                sum+=v;
                if(sum<0){
                    s=Math.min(s,sum);
                }
            }
            //System.out.println(s);
            rs=Math.min(Math.abs(s),rs);
        }
        return rs+1;
    }
    public void dfs(int i,int j,int[][] dungeon,List<Integer> path,List<List<Integer>> paths){
        int m=dungeon.length;
        int n=dungeon[0].length;
        if(i==m-1&&j==n-1){
            paths.add(new ArrayList<Integer>(path));
            return;
        }
        if(i<m-1){
            path.add(dungeon[i+1][j]);
            dfs(i+1,j,dungeon,path,paths);
            path.remove(path.size()-1);
        }
        if(j<n-1){
            path.add(dungeon[i][j+1]);
            dfs(i,j+1,dungeon,path,paths);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[][] dungeon={
                {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}
        };
        System.out.println(solution.calculateMinimumHP(dungeon));
    }
}
