package no123_maxProfit;

public class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            //对于buy1而言，在第i天我们可以不进行任何操作，保持不变，也可以在未进行任何操作的前提下，以prices[i]的价格买入股票
            buy1 = Math.max(buy1, -prices[i]);
            //对于sell1而言，在第i天我们可以不进行任何操作，保持不变，也可以在只进行过一次买操作的前提下，以prices[i]的价格卖出股票
            sell1 = Math.max(sell1, buy1 + prices[i]);
            //对于buy2而言，在第i天我们可以不进行任何操作，保持不变，也可以在完成了一笔交易的前提下，以prices[i]的价格买入股票
            buy2 = Math.max(buy2, sell1 - prices[i]);
            //对于sell2而言，在第i天我们可以不进行任何操作，保持不变，也可以完成了全部两笔交易
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
    public static void main(String[] args) {
        int[] prices={3,3,5,0,0,3,1,4};
        Solution solution=new Solution();
        System.out.println(solution.maxProfit(prices));
    }
}