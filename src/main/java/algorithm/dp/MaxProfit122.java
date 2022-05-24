package algorithm.dp;

/**
 * 题目：122. 买卖股票的最佳时机 II
 * 解题思路：
 * 1.动态规划
 * 2.当前只有两种状态：持有股票、没有股票的累计利润
 * 3.持有股票取决于前一天，前天没买今天买的，前天买了今天不操作
 *   不持有股票取决于前一天，前天没有买，今天卖掉了
 */
public class MaxProfit122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[n-1][0];
    }
}
