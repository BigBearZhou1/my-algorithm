package algorithm.array;


import java.util.Arrays;

public class NextPermutation31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    swap(nums, j, i);
                    Arrays.sort(nums, i + 1, n);
                    return;
                }
            }
        }
        Arrays.sort(nums);
        return;
    }

    private void swap(int[] nums, int j, int i) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        NextPermutation31 test = new NextPermutation31();
        test.nextPermutation(new int[]{1,2,3});

    }
}
