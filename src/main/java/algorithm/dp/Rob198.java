package algorithm.dp;

import java.util.Arrays;
import java.util.List;

public class Rob198 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int[] nums1 = {2, 7, 9, 3, 1};
        Rob198 rob198 = new Rob198();
        int rob = rob198.rob(nums1);
        System.out.println(rob);
    }
}
