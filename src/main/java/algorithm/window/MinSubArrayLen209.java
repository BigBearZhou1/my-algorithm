package algorithm.window;

public class MinSubArrayLen209 {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 1;
        int res = Integer.MAX_VALUE;
        int sum = nums[0];

        while (l < nums.length) {
            if (l > 0) {
                sum -= nums[l - 1];
            }
            while (sum < target && r < nums.length) {
                sum += nums[r++];
            }
            if (sum == target) {
                res = Math.min(res, r - l);
            }
            r--;
            sum -= nums[r];
            l++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        MinSubArrayLen209 solution = new MinSubArrayLen209();
        int res = solution.minSubArrayLen(11, new int[]{1,1,1});
        System.out.println(res);
    }
}
