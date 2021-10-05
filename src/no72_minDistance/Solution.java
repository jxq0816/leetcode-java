package no72_minDistance;

public class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        if(n*m==0){
            return n+m;
        }
        int[][] dp=new int[n+1][m+1];
        //边界状态初始化
        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<=m;i++){
            dp[0][i]=i;
        }
        //计算所有 DP 值
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int left=dp[i][j-1]+1;
                int down=dp[i-1][j]+1;
                int leftDown=dp[i-1][j-1];
                if(word1.charAt(i-1)!=word2.charAt(j-1)){
                    leftDown+=1;
                }
                dp[i][j]=Math.min(Math.min(left,down),leftDown);
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.minDistance("horse","ros"));
    }
}
