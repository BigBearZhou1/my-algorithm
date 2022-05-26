package algorithm.array;

/**
 * 题目：300. 最长递增子序列
 * 解题思路：
 * 1. 动态规划
 * 2. 状态转移公式：第i个是前面的递增就加一中，最大的那个
 */
public class LengthOfLIS300 {
    public int lengthOfLIS(int[] nums) {
        int res =1;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
