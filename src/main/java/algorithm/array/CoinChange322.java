package algorithm.array;

import java.util.Arrays;

/**
 * 题目：322. 零钱兑换
 * 解题思路：
 * 1. 动态规划
 * 2. 状态转移方程：F(S)=MIN(F(S-ci)+1
 * 3. 预制dp数组中默认值是最大找零数+1
 * 4. 如果最后的dp数组中的amount位是比amount大,就证明找不开
 */
public class CoinChange322 {
    public int coinChange(int[] coins, int amount) {
        int maxValue = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, maxValue);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
