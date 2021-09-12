package no120_minimumTotal;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        dp[0][0]=triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            dp[i][0]=dp[i-1][0]+triangle.get(i).get(0);
            for(int j=1;j<i;j++){
                dp[i][j]=Integer.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j);
            }
            dp[i][i]=dp[i-1][i-1]+triangle.get(i).get(i);
        }
        int rs=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            rs=Integer.min(rs,dp[n-1][i]);
        }
        return rs;
    }


    public static void main(String[] args) {
        Solution2 solution=new Solution2();
        List<List<Integer>> triangle=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        list.add(2);
        List<Integer> list2=new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3=new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4=new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        System.out.println(solution.minimumTotal(triangle));
    }
}
