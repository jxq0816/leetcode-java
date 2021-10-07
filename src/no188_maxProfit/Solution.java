package no188_maxProfit;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int len = prices.length;
        //第0天没有操作,dp[0][0]=0
        int[][] dp = new int[len][k*2 + 1];
        // dp数组的初始化，奇数是买入
        for (int i = 1; i < k*2; i += 2) {
            dp[0][i] = -prices[0];
        }
        //天数
        for (int i = 1; i < len; i++) {
            //股票状态: 奇数表示第k次交易持有/买入, 偶数表示第k次交易不持有/卖出, 0表示没有操作
            for (int j = 0; j < k*2 - 1; j += 2) {
                //买入
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                //卖出
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[len - 1][k*2];
    }

    public static void main(String[] args) {
        int k = 2;
        int[] prices = {2,4,1};
        Solution solution=new Solution();
        System.out.println(solution.maxProfit(k,prices));
    }
}


